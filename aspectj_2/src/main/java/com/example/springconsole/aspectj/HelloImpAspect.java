package com.example.springconsole.aspectj;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class HelloImpAspect {
    @Before("call(* execute(..))")
    public void callFromFoo() {
        System.out.println("--- @Aspect ---");
    }
}
