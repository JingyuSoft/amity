package com.jingyusoft.amity.thrift;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.apache.thrift.TProcessor;
import org.apache.thrift.server.TServer;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.jingyusoft.amity.common.AmityLogger;
import com.jingyusoft.amity.common.WrappedException;
import com.jingyusoft.amity.thrift.generated.AmityService;
import com.jingyusoft.amity.thrift.generated.ItineraryService;

@Service
public class AmityThriftServer {

	private static final Logger LOGGER = AmityLogger.getLogger();

	@Resource
	private ThriftServerFactory thriftServerFactory;

	@Resource
	private AmityService.Iface amityService;

	@Resource
	private ItineraryService.Iface itineraryService;

	@Value("${amity.server.host}")
	private String host;

	@Value("${amity.server.port}")
	private int port;

	@Value("${amity.server.handlers}")
	private int handlers;

	@PostConstruct
	public void start() {

		new Thread(new Runnable() {

			@Override
			public void run() {
				startDataServer();
			}
		}).start();
	}

	private void startDataServer() {

		try {
			TServer amityServer = thriftServerFactory.create(new TProcessor[] {
					new AmityService.Processor<AmityService.Iface>(amityService),
					new ItineraryService.Processor<ItineraryService.Iface>(itineraryService) }, port, handlers);
			LOGGER.info("Amity server started on {}:{}", host, port);
			amityServer.serve();

		} catch (Exception e) {
			throw WrappedException.insteadOf(e);
		}
	}
}
