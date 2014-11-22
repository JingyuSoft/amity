package com.jingyusoft.amity.thrift;

import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadedSelectorServer;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TNonblockingServerTransport;
import org.apache.thrift.transport.TTransportException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.jingyusoft.amity.common.WrappedException;

@Repository
public class ThriftServerFactory {

	@Value("${thrift.server.selector.threads}")
	private int selectorThreads;

	public TServer create(TProcessor processor, int port, int workerThreads) {

		try {
			TNonblockingServerTransport transport = new TNonblockingServerSocket(port);
			TThreadedSelectorServer.Args args = new TThreadedSelectorServer.Args(transport);
			args.transportFactory(new TFramedTransport.Factory());
			args.protocolFactory(new TBinaryProtocol.Factory());
			args.processor(processor);
			args.selectorThreads(selectorThreads);
			args.workerThreads(workerThreads);
			return new TThreadedSelectorServer(args);
		} catch (TTransportException e) {
			throw WrappedException.insteadOf(e);
		}
	}
}
