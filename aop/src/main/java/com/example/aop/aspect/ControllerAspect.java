package com.example.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class ControllerAspect {
    //all controllers
    //    @Around("@within(org.springframework.stereotype.Controller) ")
    //all in controllers folder
    //    @Around("execution(* com.example.springconsole.controllers.*.*(..)))")
    //all in controllers folder except retry method
    @Around("execution(* com.example.aop.controllers.*.*(..)) && !execution(* com.example.aop.controllers.MainController.retry(..))")
    public Object invoke(final ProceedingJoinPoint pjp) throws Throwable {
        try {
            Object[] args = pjp.getArgs();
            System.out.println("args:" + Arrays.asList(args));
            Object o = pjp.proceed();
            System.out.println("return :" + o);
            return o;
        } catch (Throwable e) {
            throw e;
        }
    }
}