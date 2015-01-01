package com.jingyusoft.amity.thrift.services;

import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import com.jingyusoft.amity.common.AmityLogger;
import com.jingyusoft.amity.diagnostics.ExecutionTimed;
import com.jingyusoft.amity.thrift.generated.AmityService;

@Service
public class AmityThriftServiceImpl implements AmityService.Iface {

	private static final Logger LOGGER = AmityLogger.getLogger();

	@Override
	@ExecutionTimed
	public String echo(String request) throws TException {

		LOGGER.info("Received: {}", request);

		return request;
	}
}
