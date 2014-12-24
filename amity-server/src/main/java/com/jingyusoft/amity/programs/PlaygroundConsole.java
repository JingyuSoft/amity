package com.jingyusoft.amity.programs;

import org.apache.commons.lang3.RandomStringUtils;

import com.jingyusoft.amity.common.SecurityUtils;

public class PlaygroundConsole extends TestConsoleBase {

	@Override
	protected void startConsole() {

		for (int i = 0; i < 10; i++) {
			final String random = RandomStringUtils.random(64, true, true);
			System.out.println(random);
			System.err.println(SecurityUtils.getBase64SHA256Hash(random));
		}
	}
}
