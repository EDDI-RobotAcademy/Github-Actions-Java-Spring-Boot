package com.example.demo.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class SecurityChecker {

  @Pointcut("@annotation(SecurityCheck)")
  public void checkMethodSecurity() {}

  @Around("checkMethodSecurity()")
  public Object checkSecurity (ProceedingJoinPoint joinPoint) throws Throwable {
    log.info("Checking method security...");

    Object result = joinPoint.proceed();
    return result;
  }
}
