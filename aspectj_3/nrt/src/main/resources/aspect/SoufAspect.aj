package org.example.nrt.aspect;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public aspect SoufAspect {
    private Logger LOGGER = LoggerFactory.getLogger(SoufAspect.class);
    pointcut souf():call(* printf(..));

    before():souf(){
        LOGGER.warn("***   @Aspectj   ***");
    }
}
