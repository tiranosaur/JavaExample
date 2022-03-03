package com.utils.retryLibrary.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class TestAspect {
    @Pointcut("@annotation(com.utils.retryLibrary.annotation.TestRetryLibrary)")
    public void testRetryLibrary() {
    }

    @Around("testRetryLibrary()")
    public Object test(final ProceedingJoinPoint pjp) throws Throwable {
        log.info("*****     TestRetryLibrary is running     *****");
        return pjp.proceed();

    }
}
