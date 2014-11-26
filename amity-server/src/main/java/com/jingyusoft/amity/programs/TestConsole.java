package com.jingyusoft.amity.programs;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.jingyusoft.amity.authentication.facebook.FacebookAuthenticationService;
import com.jingyusoft.amity.authentication.facebook.FacebookUserInfo;
import com.jingyusoft.amity.common.HostPort;
import com.jingyusoft.amity.common.WrappedException;
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

	@PostConstruct
	public void start() {
		FacebookUserInfo facebookUserInfo = facebookAuthenticationService
				.getUserInfo("CAACEdEose0cBAKOv8hx12VcCZBwtN5xpH8fzZBSYI96U9EcrekZBvwE97NBeI9Scf1ZCdZAORGfZAkQ36D2bcM02GQZBqk3cG1Wm7hRzrOxdv4knqGXw41PTNOmo3NK4SQxTMrTZCydwS47Bp8g7APnw2gm0Pv7fyyDL7QI9Jovfgl6Ph59YkQoTaibhHNCjaEJL0ofR4nypYZArCXS7mnn5gArsXNZAfRldYZD");
		System.out.println(facebookUserInfo.getName());
		System.out.println(facebookUserInfo.getUpdatedTime());
	}

	@SuppressWarnings("unused")
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
