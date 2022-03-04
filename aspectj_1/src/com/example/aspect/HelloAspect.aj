package com.example.aspect;

public aspect HelloAspect {
    pointcut sayHello():call(* *.sayHello(..));

    void around():sayHello(){
        proceed();
        System.out.println("Hello, AspectJ!");
    }
}
