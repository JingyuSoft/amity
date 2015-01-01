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

	@Around("execution(* *(..)) && @annotation(com.jingyusoft.amity.diagnostics.ExecutionTimed)")
	public Object timeExecution(ProceedingJoinPoint joinPoint) {
		long start = System.nanoTime();
		try {
			return joinPoint.proceed();
		} catch (Throwable e) {
			throw WrappedException.insteadOf(e);
		} finally {
			long end = System.nanoTime();
			long duration = end - start / 1000;
			LOGGER.debug("Method [{}] executed in {} microseconds", joinPoint.getSignature().getDeclaringTypeName()
					+ "." + joinPoint.getSignature().getName(), duration);
		}
	}
}
