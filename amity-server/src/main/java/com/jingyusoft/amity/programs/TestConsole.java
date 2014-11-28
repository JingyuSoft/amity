package com.jingyusoft.amity.programs;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.jingyusoft.amity.authentication.facebook.FacebookAuthenticationService;
import com.jingyusoft.amity.common.HostPort;
import com.jingyusoft.amity.common.WrappedException;
import com.jingyusoft.amity.data.entities.AmityUserEntity;
import com.jingyusoft.amity.data.repositories.AmityUserRepository;
import com.jingyusoft.amity.thrift.factories.ThriftClientFactory;
import com.jingyusoft.amity.thrift.factories.ThriftClientFactory.ThriftClientHolder;
import com.jingyusoft.amity.thrift.generated.AmityService;

@Service
public class TestConsole {

	@Value("${amity.server.host}")
	private String host;

	@Value("${amity.server.port}")
	private int port;

	@Resource
	private ThriftClientFactory thriftClientFactory;

	@Resource
	private FacebookAuthenticationService facebookAuthenticationService;

	@Resource
	private AmityUserRepository amityUserRepository;

	@PostConstruct
	public void start() {

		List<AmityUserEntity> list = amityUserRepository.findAll();
		System.err.println(list.size());

		// thriftDemo();
	}

	private void thriftDemo() {

		HostPort hostPort = HostPort.from(host, port);
		try (ThriftClientHolder<AmityService.Iface> holder = thriftClientFactory.getClient(hostPort,
				AmityService.Iface.class)) {
			System.out.println(holder.getClient().echo("Hello"));
		} catch (Exception e) {
			throw WrappedException.insteadOf(e);
		}
	}
}
