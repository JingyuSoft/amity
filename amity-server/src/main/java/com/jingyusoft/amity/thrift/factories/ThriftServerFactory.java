package com.jingyusoft.amity.thrift.factories;

import org.apache.thrift.TMultiplexedProcessor;
import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSSLTransportFactory;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.jingyusoft.amity.AmityException;
import com.jingyusoft.amity.common.AmityLogger;
import com.jingyusoft.amity.common.SecurityUtils;
import com.jingyusoft.amity.common.WrappedException;

@Repository
public class ThriftServerFactory {

	private static final Logger LOGGER = AmityLogger.getLogger();

	@Value("${amity.server.port}")
	private int port;

	@Value("${amity.server.port.ssl}")
	private int sslPort;

	@Value("${thrift.server.min.threads}")
	private int minWorkerThreads;

	@Value("${thrift.server.max.threads}")
	private int maxWorkerThreads;

	@Value("${thrift.client.timeout}")
	private int clientTimeout;

	@Value("${thrift.keystore.file}")
	private String keyStore;

	@Value("${thrift.keystore.password.file}")
	private String keyPassFile;

	public TServer create(TProcessor processor, boolean ssl, int workerThreads) {

		return create(new TProcessor[] { processor }, ssl, workerThreads);
	}

	public TServer create(TProcessor[] processors, boolean ssl, int workerThreads) {

		if (processors == null || processors.length == 0) {
			throw new AmityException("Thrift processor not specified");
		}

		try {
			TServerSocket transport = null;
			if (ssl) {
				TSSLTransportFactory.TSSLTransportParameters params = new TSSLTransportFactory.TSSLTransportParameters();
				final String keyStorePassword = SecurityUtils.getPasswordFromFile(keyPassFile);
				params.setKeyStore(keyStore, keyStorePassword);
				transport = TSSLTransportFactory.getServerSocket(sslPort, clientTimeout, null, params);
			} else {
				transport = new TServerSocket(port);
			}

			TThreadPoolServer.Args args = new TThreadPoolServer.Args(transport);
			args.minWorkerThreads(minWorkerThreads);
			args.maxWorkerThreads(maxWorkerThreads);
			args.transportFactory(new TFramedTransport.Factory());
			args.protocolFactory(new TBinaryProtocol.Factory());
			if (processors.length == 1) {
				TProcessor processor = processors[0];
				final String serviceName = processor.getClass().getDeclaringClass().getSimpleName();
				args.processor(processor);
				LOGGER.info("Thrift service [{}] registered", serviceName);
			} else {
				TMultiplexedProcessor multiplexedProcessor = new TMultiplexedProcessor();
				for (TProcessor processor : processors) {
					final String serviceName = processor.getClass().getDeclaringClass().getSimpleName();
					multiplexedProcessor.registerProcessor(serviceName, processor);
					LOGGER.info("Thrift service [{}] registered in multiplex processor", serviceName);
				}
				args.processor(multiplexedProcessor);
			}
			return new TThreadPoolServer(args);
		} catch (TTransportException e) {
			throw WrappedException.insteadOf(e);
		}
	}
}
