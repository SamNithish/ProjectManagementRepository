package com.phoenix.pma.logging;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ApplicationLoggerAspect {
	
//	Logging is an APIthat provides the ability to trace out the errors of the applications

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Pointcut("within(com.phoenix.pma.controllers..*)")
	public void definePackagePointcuts() {
		// empty method just to name the location specified to the PointCut
	}
	
//	//before execution
//	@Before("definePackagePointcuts()")
//	public void logBefore(JoinPoint jp) {
//
//		log.debug("\n\n\n");
//		log.debug("*****************  before Method Execution *******************\n\n\n");
//		log.debug("\n\n\n{}.{} () with arguments[s] = {} \n\n\n", jp.getSignature().getDeclaringTypeName(),
//				jp.getSignature().getName(), Arrays.toString(jp.getArgs()));
//		log.debug("\n\n\n");
//
//	}
//
//	//after execution
//	@After("definePackagePointcuts()")
//	public void logAfter(JoinPoint jp) {
//
//		log.debug("\n\n\n");
//		log.debug("*****************  after Method Execution *******************\n\n\n");
//		log.debug("\n\n\n{}.{} () with arguments[s] = {} \n\n\n", jp.getSignature().getDeclaringTypeName(),
//				jp.getSignature().getName(), Arrays.toString(jp.getArgs()));
//		log.debug("\n\n\n");
//
//	}
	
	//both before and after execution done by an annotation called @Around
	@Around("definePackagePointcuts()")
	public Object logAfter(ProceedingJoinPoint jp) throws Throwable {

		log.debug("\n\n\n");
		log.debug("*****************  before Method Execution *******************\n\n\n");
		log.debug("\n\n\n{}.{} () with arguments[s] = {} \n\n\n", jp.getSignature().getDeclaringTypeName(),
				jp.getSignature().getName(), Arrays.toString(jp.getArgs()));
		
		Object o = jp.proceed();
		
		log.debug("\n\n\n");
		log.debug("*****************  after Method Execution *******************\n\n\n");
		log.debug("\n\n\n{}.{} () with arguments[s] = {} \n\n\n", jp.getSignature().getDeclaringTypeName(),
				jp.getSignature().getName(), Arrays.toString(jp.getArgs()));
		return o;
		
//		more knowledge about AOP will be gain through the following webSite spring.io chapter 6 

	}

}
