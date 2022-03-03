package com.utils.retryLibrary.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PerfomanceAspect {
    @Pointcut("bean(*ExternalService) && !@annotation(com.utils.retryLibrary.annotation.ExceptRetry)")
    public void externalServiceMethods(){}

    @Pointcut("@within(org.springframework.cloud.openfeign.FeignClient)")
    public void feignClientMethods(){}

    @Pointcut("@target(javax.jws.soap.SOAPBinding) && execution(* *.execute(..))")
    public void bapClientExecute(){}

    @Around("externalServiceMethods() || feignClientMethods()|| bapClientExecute()")
    public Object invoke(final ProceedingJoinPoint pjp) throws Throwable {
        long startTime = System.currentTimeMillis();
        try {
            return pjp.proceed();
        } catch (Throwable e) {
            throw e;
        } finally {
            long endTime = System.currentTimeMillis();
            long executionTime = endTime - startTime;
            System.out.println("Method Name: " + pjp.getClass().getName() + " Execution Time:- " + executionTime + " ms");
        }
    }
}
