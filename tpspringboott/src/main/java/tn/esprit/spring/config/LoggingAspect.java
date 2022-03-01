package tn.esprit.spring.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@Aspect
public class LoggingAspect {
	@Before("execution(* tn.esprit.spring.service.StockServiceImpl.*(..))")
	public void logMethodEntry(JoinPoint joinPoint) {
	String name = joinPoint.getSignature().getName();
	log.info("In method " + name + " : ");
	}
}
