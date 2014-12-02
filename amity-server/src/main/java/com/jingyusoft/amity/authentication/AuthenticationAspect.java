package com.jingyusoft.amity.authentication;

import java.lang.reflect.Field;

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

	private static final Object createErrorResponse(final Class<?> clazz, final String message) {
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

	private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationAspect.class);

	@Around("execution(* *(.., com.jingyusoft.amity.thrift.generated.SessionCredentials))")
	public Object authenticate(ProceedingJoinPoint joinPoint) {

		if (joinPoint.getArgs().length != 2 || joinPoint.getArgs()[1] != null
				&& !(joinPoint.getArgs()[1] instanceof SessionCredentials)) {
			try {
				return joinPoint.proceed();
			} catch (Throwable e) {
				throw WrappedException.insteadOf(e);
			}
		}

		SessionCredentials credentials = (SessionCredentials) joinPoint.getArgs()[1];
		Class<?> returnType = ((MethodSignature) joinPoint.getSignature()).getReturnType();
		if (credentials == null) {
			return createErrorResponse(returnType, "Credentials does not exist");
		}

		boolean authenticated = true;

		if (!authenticated) {
			LOGGER.warn("Invalid credentials [{}]", credentials.toString());
			return createErrorResponse(returnType, "Credentials invalid");
		}

		try {
			return joinPoint.proceed();
		} catch (Throwable e) {
			throw WrappedException.insteadOf(e);
		}
	}
}
