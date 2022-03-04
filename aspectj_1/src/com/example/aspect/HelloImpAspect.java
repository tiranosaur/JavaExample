package com.example.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class HelloImpAspect {
    @Before("call(* *.sayHello(..))")
    public void callFromFoo() {
        System.out.println("--- @Aspect ---");
    }
}
