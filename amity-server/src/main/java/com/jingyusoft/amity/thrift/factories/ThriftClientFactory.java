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
import org.apache.thrift.transport.TSSLTransportFactory;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.jingyusoft.amity.AmityException;
import com.jingyusoft.amity.common.AmityLogger;
import com.jingyusoft.amity.common.HostPort;
import com.jingyusoft.amity.common.SecurityUtils;
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
			TSSLTransportFactory.TSSLTransportParameters params = new TSSLTransportFactory.TSSLTransportParameters();
			final String trustStorePassword = SecurityUtils.getPasswordFromFile(trustPassFile);
			params.setTrustStore(trustStore, trustStorePassword);

			TTransport transport = null;
			try {
				transport = TSSLTransportFactory.getClientSocket(hostPort.getHost(), hostPort.getPort(), clientTimeout,
						params);
				transport = new TFramedTransport(transport);
			} catch (TTransportException e) {
				throw new AmityException(StringMessage.with("Failed to connect to worker server {}", hostPort), e);
			}

			final String serviceName = clientClass.getDeclaringClass().getSimpleName();
			TProtocol protocol = new TMultiplexedProtocol(new TBinaryProtocol(transport), serviceName);
			try {
				T client = clientClass.getConstructor(TProtocol.class).newInstance(protocol);
				LOGGER.debug("Thrift client created for type [{}]", clientClass.getName());
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

	public static class ThriftClientHolder<T> implements AutoCloseable {

		private static <T> ThriftClientHolder<T> create(final ThriftClientFactory thriftClientFactory, T client,
				final String clientPoolKey) {
			ThriftClientHolder<T> holder = new ThriftClientHolder<T>();
			holder.thriftClientFactory = thriftClientFactory;
			holder.client = client;
			holder.clientPoolKey = clientPoolKey;
			return holder;
		}

		private ThriftClientFactory thriftClientFactory;

		private T client;

		private String clientPoolKey;

		@Override
		public void close() throws Exception {
			thriftClientFactory.returnClient(client, clientPoolKey);
		}

		public T getClient() {
			return client;
		}
	}

	private static class ThriftClientPool<U> {

		private static final Logger LOGGER = AmityLogger.getLogger();

		private int freeCount = 0;

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

			--freeCount;
			U client = list.remove(0);
			LOGGER.info("Thrift client of type [{}] acquired from pool. Free = [{}]", interfaceClass.getName(),
					freeCount);
			return interfaceClass.cast(client);
		}

		public void returnClient(U client) {
			++freeCount;
			LOGGER.info("Thrift client of type [{}] returned to pool. Free = [{}]", interfaceClass.getName(), freeCount);
		}
	}

	private static final String getClientPoolKey(final HostPort hostPort, Class<?> interfaceClass) {
		return hostPort + "_" + interfaceClass.getName();
	}

	@Value("${thrift.truststore.file}")
	private String trustStore;

	@Value("${thrift.truststore.password.file}")
	private String trustPassFile;

	@Value("${thrift.client.timeout}")
	private int clientTimeout;

	private static final Logger LOGGER = AmityLogger.getLogger();

	private final Map<String, ThriftClientPool<?>> clientPools = Maps.newHashMap();

	public synchronized <T extends U, U> ThriftClientHolder<U> getClient(final HostPort hostPort, Class<T> clientClass,
			Class<U> interfaceClass) {

		final String clientPoolKey = getClientPoolKey(hostPort, interfaceClass);
		ThriftClientPool<?> clientPool = clientPools.get(clientPoolKey);
		if (clientPool == null) {
			clientPool = new ThriftClientPool<T>(clientClass);
			clientPools.put(clientPoolKey, clientPool);
			LOGGER.debug("Thrift client pool created with key [{}]", clientPoolKey);
		}

		Object client = clientPool.acquireClient();
		if (client == null) {
			U proxiedClient = interfaceClass.cast(Enhancer.create(interfaceClass,
					new AutoReconnectInvocationHandler<T>(hostPort, clientClass)));
			return ThriftClientHolder.create(this, proxiedClient, clientPoolKey);
		} else {
			return ThriftClientHolder.create(this, interfaceClass.cast(client), clientPoolKey);
		}
	}

	public synchronized <T extends U, U> ThriftClientHolder<U> getClient(final HostPort hostPort,
			Class<U> interfaceClass) {
		try {
			@SuppressWarnings("unchecked")
			final Class<T> clientClass = (Class<T>) Class.forName(interfaceClass.getDeclaringClass().getName()
					+ "$Client");
			return getClient(hostPort, clientClass, interfaceClass);
		} catch (Exception e) {
			throw WrappedException.insteadOf(e);
		}
	}

	private synchronized <U> void returnClient(final U client, final HostPort hostPort) {

		final String clientClassName = client.getClass().getName();
		final String interfaceClassName = clientClassName.substring(0, clientClassName.indexOf("$$EnhancerByCGLIB"));

		String clientPoolKey;
		try {
			clientPoolKey = getClientPoolKey(hostPort, Class.forName(interfaceClassName));
		} catch (ClassNotFoundException e) {
			throw WrappedException.insteadOf(e);
		}

		returnClient(client, clientPoolKey);
	}

	private synchronized <U> void returnClient(final U client, final String clientPoolKey) {

		@SuppressWarnings("unchecked")
		ThriftClientPool<U> clientPool = (ThriftClientPool<U>) clientPools.get(clientPoolKey);

		if (clientPool == null) {
			throw new AmityException("Thrift client pool not found for client class [" + client.getClass().getName()
					+ "]");
		}

		clientPool.returnClient(client);
		LOGGER.debug("Thrift client returned to pool [{}]", clientPoolKey);
	}
}
