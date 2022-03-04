package com.utils.retryLibrary.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class RetryClientAspect {
    @Value("${http.retry.max-attempts:3}")
    private int maxAttempts;

    @Value("${http.retry.delay:1000}")
    private int delay;

    @Pointcut("bean(*ExternalService) && !@annotation(com.utils.retryLibrary.annotation.ExceptRetry)")
    public void externalServiceMethods(){}

    @Pointcut("@within(org.springframework.cloud.openfeign.FeignClient)")
    public void feignClientMethods(){}

    @Around("externalServiceMethods() || feignClientMethods()")
    public Object aroundInvoke(final ProceedingJoinPoint pjp) throws Throwable {
        int counter = maxAttempts;
        while (true) {
            try {
                return pjp.proceed();
            } catch (Throwable t) {
                if (counter == 1) {
                    t.printStackTrace();
                    break;
                }
            }
            counter--;
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
