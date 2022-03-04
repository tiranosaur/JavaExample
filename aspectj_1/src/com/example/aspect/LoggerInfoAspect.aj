package com.example.aspect;

public aspect LoggerInfoAspect {
    pointcut xxx():call(* *.info(String));

    void around():xxx(){
        System.out.println();
        System.out.println("*****************************");
//        proceed();
        System.out.println("My custom logger");
        System.out.println("*****************************");
        System.out.println();
    }
}
