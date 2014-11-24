package com.jingyusoft.amity.thrift.factories;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TMultiplexedProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;
import org.slf4j.Logger;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.jingyusoft.amity.AmityException;
import com.jingyusoft.amity.common.AmityLogger;
import com.jingyusoft.amity.common.HostPort;
import com.jingyusoft.amity.common.StringMessage;
import com.jingyusoft.amity.common.WrappedException;

@Repository
public class ThriftClientFactory {

	private class AutoReconnectInvocationHandler<T> implements MethodInterceptor {

		private final HostPort hostPort;

		private final Class<T> clientClass;

		private T client;

		public AutoReconnectInvocationHandler(final HostPort hostPort, Class<T> clientClass) {
			this.hostPort = hostPort;
			this.clientClass = clientClass;
		}

		private T createClient() {
			TTransport transport = new TSocket(hostPort.getHost(), hostPort.getPort());
			transport = new TFramedTransport(transport);
			try {
				transport.open();
			} catch (TTransportException e) {
				if (transport != null) {
					transport.close();
				}
				throw new AmityException(StringMessage.with("Failed to connect to worker server {}", hostPort), e);
			}

			final String serviceName = clientClass.getDeclaringClass().getSimpleName();
			TProtocol protocol = new TMultiplexedProtocol(new TBinaryProtocol(transport), serviceName);
			try {
				T client = clientClass.getConstructor(TProtocol.class).newInstance(protocol);
				LOGGER.info("Thrift client created for type [{}]", clientClass.getName());
				return client;
			} catch (Exception e) {
				throw WrappedException.insteadOf(e);
			}
		}

		@Override
		public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
			try {
				if (client == null) {
					client = createClient();
				}
				return proxy.invoke(client, args);
			} catch (TTransportException e) {
				LOGGER.warn("Recreating Thrift client for type [{}]", clientClass.getName());
				client = createClient();
				return proxy.invoke(client, args);
			}
		}
	}

	private static class ThriftClientPool<U> {

		private static final Logger LOGGER = AmityLogger.getLogger();

		private int poolSize = 0;

		private final Class<U> interfaceClass;

		private final List<U> list = Lists.newArrayList();

		private ThriftClientPool(Class<U> interfaceClass) {
			this.interfaceClass = interfaceClass;
			LOGGER.info("Thrift client pool created for client type [{}]", interfaceClass.getName());
		}

		public U acquireClient() {
			if (list.size() == 0) {
				return null;
			}

			--poolSize;
			U client = list.remove(0);
			LOGGER.info("Thrift client of type [{}] acquired from pool. Pool size = [{}]", interfaceClass.getName(),
					poolSize);
			return interfaceClass.cast(client);
		}

		public void returnClient(U client) {
			++poolSize;
			LOGGER.info("Thrift client of type [{}] returned to pool. Pool size = [{}]", interfaceClass.getName(),
					poolSize);
		}
	}

	private static final String getClientKey(final HostPort hostPort, Class<?> clientClass) {
		return hostPort + "_" + clientClass.getName();
	}

	private static final Logger LOGGER = AmityLogger.getLogger();

	private final Map<String, ThriftClientPool<?>> clientPools = Maps.newHashMap();

	public synchronized <T extends U, U> U getClient(final HostPort hostPort, Class<T> clientClass,
			Class<U> interfaceClass) {

		final String clientKey = getClientKey(hostPort, interfaceClass);
		ThriftClientPool<?> clientPool = clientPools.get(clientKey);
		if (clientPool == null) {
			clientPool = new ThriftClientPool<T>(clientClass);
			clientPools.put(clientKey, clientPool);
		}

		Object client = clientPool.acquireClient();
		if (client == null) {
			U proxiedClient = interfaceClass.cast(Enhancer.create(interfaceClass,
					new AutoReconnectInvocationHandler<T>(hostPort, clientClass)));
			return proxiedClient;
		} else {
			return interfaceClass.cast(client);
		}
	}

	@SuppressWarnings("unchecked")
	public synchronized <U> void returnClient(final U client, final HostPort hostPort) {

		final String clientClassName = client.getClass().getName();
		final String interfaceClassName = clientClassName.substring(0, clientClassName.indexOf("$$EnhancerByCGLIB"));

		ThriftClientPool<U> clientPool;
		try {
			clientPool = (ThriftClientPool<U>) clientPools
					.get(getClientKey(hostPort, Class.forName(interfaceClassName)));
		} catch (ClassNotFoundException e) {
			throw WrappedException.insteadOf(e);
		}

		if (clientPool == null) {
			throw new AmityException("Thrift client pool not found for client class [" + client.getClass().getName()
					+ "]");
		}

		clientPool.returnClient(client);
	}
}
