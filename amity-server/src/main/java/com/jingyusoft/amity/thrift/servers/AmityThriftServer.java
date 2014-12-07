package com.jingyusoft.amity.thrift.servers;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.apache.thrift.TProcessor;
import org.apache.thrift.server.TServer;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.jingyusoft.amity.common.AmityLogger;
import com.jingyusoft.amity.common.WrappedException;
import com.jingyusoft.amity.thrift.factories.ThriftServerFactory;
import com.jingyusoft.amity.thrift.generated.AmityService;
import com.jingyusoft.amity.thrift.generated.AuthenticationThriftService;
import com.jingyusoft.amity.thrift.generated.ItineraryThriftService;

@Service
public class AmityThriftServer {

	private static final Logger LOGGER = AmityLogger.getLogger();

	@Resource
	private ThriftServerFactory thriftServerFactory;

	@Resource
	private AmityService.Iface amityService;

	@Resource
	private ItineraryThriftService.Iface itineraryThriftService;

	@Resource
	private AuthenticationThriftService.Iface authenticationThriftService;

	@Value("${amity.server.host}")
	private String host;

	@Value("${amity.server.port}")
	private int port;

	@Value("${amity.server.port.ssl}")
	private int sslPort;

	@Value("${amity.server.handlers}")
	private int handlers;

	private int getPort(boolean ssl) {
		return ssl ? sslPort : port;
	}

	@PostConstruct
	public void start() {

		new Thread(new Runnable() {

			@Override
			public void run() {
				startDataServer(false);
			}
		}).start();

		new Thread(new Runnable() {

			@Override
			public void run() {
				startDataServer(true);
			}
		}).start();
	}

	private void startDataServer(boolean ssl) {

		try {
			TServer amityServer = thriftServerFactory.create(new TProcessor[] {
					new AmityService.Processor<AmityService.Iface>(amityService),
					new AuthenticationThriftService.Processor<AuthenticationThriftService.Iface>(
							authenticationThriftService),
							new ItineraryThriftService.Processor<ItineraryThriftService.Iface>(itineraryThriftService) }, ssl,
							handlers);
			LOGGER.info("Amity server started on {}:{}", host, getPort(ssl));
			amityServer.serve();

		} catch (Exception e) {
			throw WrappedException.insteadOf(e);
		}
	}
}
