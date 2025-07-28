package com.sam.utility;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.sam.exception.StudentException;

@Aspect
@Component
public class LoggingAspect {
	
	private static final Log LOG = LogFactory.getLog(LoggingAspect.class);
	
	@AfterThrowing(pointcut ="execution(* com.sam.service.*Impl.*(..))",throwing = "e")
	public void loggingAspect(StudentException e)
	{
		LOG.info(e.getMessage(), e);
	}

}
