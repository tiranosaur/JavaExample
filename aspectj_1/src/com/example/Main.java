package com.example;

import com.example.model.Hello;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger(Main.class.getName());
        logger.info("xsxxxx");
        Hello hello = new Hello();
        hello.sayHello();
    }}
