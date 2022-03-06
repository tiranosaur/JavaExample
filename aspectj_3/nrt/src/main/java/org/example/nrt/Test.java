package org.example.nrt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Test {
    private static final Logger LOGGER = LoggerFactory.getLogger(Test.class);

    public static void test() {
        LOGGER.info("retry library is running");
    }

    public static void main(String[] args) {
        System.out.printf("%d",345);
    }
}
