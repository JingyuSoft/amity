package com.jingyusoft.amity.thrift;

import org.apache.thrift.TMultiplexedProcessor;
import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadedSelectorServer;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TNonblockingServerTransport;
import org.apache.thrift.transport.TTransportException;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.jingyusoft.amity.common.AmityException;
import com.jingyusoft.amity.common.AmityLogger;
import com.jingyusoft.amity.common.WrappedException;

@Repository
public class ThriftServerFactory {

	private static final Logger LOGGER = AmityLogger.getLogger();

	@Value("${thrift.server.selector.threads}")
	private int selectorThreads;

	public TServer create(TProcessor processor, int port, int workerThreads) {

		return create(new TProcessor[] { processor }, port, workerThreads);
	}

	public TServer create(TProcessor[] processors, int port, int workerThreads) {

		if (processors == null || processors.length == 0) {
			throw new AmityException("Thrift processor not specified");
		}

		try {
			TNonblockingServerTransport transport = new TNonblockingServerSocket(port);
			TThreadedSelectorServer.Args args = new TThreadedSelectorServer.Args(transport);
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
			args.selectorThreads(selectorThreads);
			args.workerThreads(workerThreads);
			return new TThreadedSelectorServer(args);
		} catch (TTransportException e) {
			throw WrappedException.insteadOf(e);
		}
	}
}
