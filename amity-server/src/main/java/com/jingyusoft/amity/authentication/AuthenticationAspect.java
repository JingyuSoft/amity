package com.jingyusoft.amity.authentication;

import java.lang.reflect.Field;

import javax.annotation.Resource;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jingyusoft.amity.common.ErrorCodes;
import com.jingyusoft.amity.common.WrappedException;
import com.jingyusoft.amity.thrift.generated.SessionCredentials;

@Aspect
public class AuthenticationAspect {

	private static final Object createErrorResponse(final Class<?> clazz) {
		try {
			Object response = clazz.newInstance();

			Field successField = clazz.getField("errorCode");
			successField.setAccessible(true);
			successField.set(response, ErrorCodes.UNAUTHORIZED);

			return response;
		} catch (Exception e) {
			throw WrappedException.insteadOf(e);
		}
	}

	@Resource
	private SessionService sessionService;

	private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationAspect.class);

	@Around("execution(public * com.jingyusoft.amity.thrift.services..*.*(.., com.jingyusoft.amity.thrift.generated.SessionCredentials))")
	public Object authenticate(ProceedingJoinPoint joinPoint) {

		SessionCredentials credentials = (SessionCredentials) joinPoint.getArgs()[joinPoint.getArgs().length - 1];
		Class<?> returnType = ((MethodSignature) joinPoint.getSignature()).getReturnType();
		if (credentials == null) {
			return createErrorResponse(returnType);
		}

		boolean authenticated = sessionService.validateSessionToken(credentials.getAmityUserId(),
				credentials.getSessionToken());

		if (!authenticated) {
			LOGGER.warn("Invalid credentials [{}]", credentials);
			return createErrorResponse(returnType);
		}

		try {
			return joinPoint.proceed();
		} catch (Throwable e) {
			throw WrappedException.insteadOf(e);
		}
	}
}
