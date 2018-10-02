package com.gosang.swp.aop;


import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SampleAdvice {
	private static final Logger logger = LoggerFactory.getLogger(SampleAdvice.class); 
	
	@Before("execution(* com.gosang.board.service.MessageService*.*(..))")
	public void startLog(JoinPoint jp) {
		logger.info("-------------------startLog-----------------");
		logger.info("pointcut >> " + jp.getSignature().getName());
		logger.info("args >> " + Arrays.toString(jp.getArgs()));	
	}
	
	@After("execution(* com.gosang.board.service.MessageService*.*(..))")
	public void endLog(JoinPoint jp) {
		logger.info("-------------------endtLog-----------------");
		logger.info("pointcut >> " + jp.getSignature().getName());
		logger.info("args >> " + Arrays.toString(jp.getArgs()));	
	}
	
	@Around("execution(* com.gosang.board.service.MessageService*.*(..))")
	public Object timeLog(ProceedingJoinPoint pjp) throws Throwable {
		long startTime = System.currentTimeMillis();
		logger.info(Arrays.toString(pjp.getArgs()));
		
		Object result = pjp.proceed();
		
		long endTime = System.currentTimeMillis();
		logger.info(">> " + pjp.getSignature().getName() + "::" + (endTime - startTime));
		logger.info("=================timeLog====================");
		return result;
	}
}

/*
  (* com.gosang.board.service.MessageService*.*(..))
 	? ?Ό ?? ?? *? ? κ·Όμ ?΄?(public, private ?±?±) ?κ΄???€
 	?λ²μ§Έ ?? * λͺ¨λ ?¨?΄ ?¬?¨?΄?? ?» ?? MessageServiceλ‘? ????¬ κ·? ?€? λͺ¨λ  ?¨?΄λ₯? ?¬?¨??€
 	?Έλ²μ§Έ *(..)? λ§€κ°λ³??κ°? ?΄?€κ²μ΄ ??? ?κ΄??΄ ??€? ?»?΄?€
 */