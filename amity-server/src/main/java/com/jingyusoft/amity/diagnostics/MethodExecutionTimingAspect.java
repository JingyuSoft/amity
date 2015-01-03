package com.jingyusoft.amity.diagnostics;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;

import com.jingyusoft.amity.common.AmityLogger;
import com.jingyusoft.amity.common.WrappedException;

@Aspect
public class MethodExecutionTimingAspect {

	private static final Logger LOGGER = AmityLogger.getLogger();

	public MethodExecutionTimingAspect() {
	}

	@Around("execution(public * com.jingyusoft.amity..*.* (..))")
	public Object timeExecution(ProceedingJoinPoint joinPoint) {
		long start = System.nanoTime();
		try {
			return joinPoint.proceed();
		} catch (Throwable e) {
			throw WrappedException.insteadOf(e);
		} finally {
			long end = System.nanoTime();
			long duration = (end - start) / 1000;
			final String message = "Method [{}] executed in {} microseconds";
			final String methodName = joinPoint.getSignature().getDeclaringTypeName() + "."
					+ joinPoint.getSignature().getName();
			if (duration > 100000) {
				LOGGER.warn(message, methodName, duration);
			} else {
				LOGGER.info(message, methodName, duration);
			}
		}
	}
}
