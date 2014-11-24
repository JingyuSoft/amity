package com.jingyusoft.amity.programs;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.jingyusoft.amity.common.HostPort;
import com.jingyusoft.amity.common.WrappedException;
import com.jingyusoft.amity.thrift.factories.ThriftClientFactory;
import com.jingyusoft.amity.thrift.generated.AmityService;
import com.jingyusoft.amity.thrift.generated.AmityService.Iface;

@Service
public class TestConsole {

	@Value("${amity.server.host}")
	private String host;

	@Value("${amity.server.port}")
	private int port;

	@Resource
	private ThriftClientFactory thriftClientFactory;

	@PostConstruct
	public void start() {

		HostPort hostPort = HostPort.from(host, port);
		Iface client = thriftClientFactory.getClient(hostPort, AmityService.Client.class, AmityService.Iface.class);
		try {
			System.out.println(client.echo("Hello"));
		} catch (TException e) {
			throw WrappedException.insteadOf(e);
		} finally {
			thriftClientFactory.returnClient(client, hostPort);
		}
	}
}
