package com.jingyusoft.amity.programs;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;

import com.jingyusoft.amity.authentication.AuthenticationService;
import com.jingyusoft.amity.common.HostPort;
import com.jingyusoft.amity.common.WrappedException;
import com.jingyusoft.amity.data.auditing.AuditQueryService;
import com.jingyusoft.amity.domain.Gender;
import com.jingyusoft.amity.thrift.factories.ThriftClientFactory;
import com.jingyusoft.amity.thrift.factories.ThriftClientFactory.ThriftClientHolder;
import com.jingyusoft.amity.thrift.generated.AmityToken;
import com.jingyusoft.amity.thrift.generated.AuthenticationThriftService;
import com.jingyusoft.amity.thrift.generated.LoginAmityAccountRequest;
import com.jingyusoft.amity.thrift.generated.LoginAmityAccountResponse;
import com.jingyusoft.amity.thrift.generated.SessionCredentials;
import com.jingyusoft.amity.thrift.generated.UpdateAmityAccountRequest;
import com.jingyusoft.amity.thrift.generated.UpdateAmityAccountResponse;

public class ThriftTestConsole extends TestConsoleBase {

	@Value("${amity.server.host}")
	private String host;

	@Value("${amity.server.port.ssl}")
	private int sslPort;

	@Resource
	private ThriftClientFactory thriftClientFactory;

	@Resource
	private AuthenticationService authenticationService;

	@Resource
	private AuditQueryService auditQueryService;

	@Override
	protected void startConsole() {
		thriftDemo();
	}

	private void thriftDemo() {

		HostPort hostPort = HostPort.from(host, sslPort);
		try (ThriftClientHolder<AuthenticationThriftService.Iface> holder = thriftClientFactory.getClient(hostPort,
				AuthenticationThriftService.Iface.class)) {

			LoginAmityAccountResponse loginResponse = holder.getClient().loginAmityAccount(
					new LoginAmityAccountRequest().setAmityUserId(1).setAuthToken(
							new AmityToken("kfWYuHC3ELUE1Gdw1NDktTSZlxyjzLFBC+JIBmDb398=")));

			UpdateAmityAccountResponse updateResponse = holder.getClient().updateAmityAccount(
					new UpdateAmityAccountRequest().setAmityUserId(1).setFirstName("Univer").setLastName("Shi")
					.setUserAlias("Univer").setGender(Gender.MALE.getCode()),
					new SessionCredentials(1, loginResponse.getSessionToken()));

			System.out.println(updateResponse.getErrorCode());

		} catch (Exception e) {
			throw WrappedException.insteadOf(e);
		}
	}
}
