package org.example.nrt.aspect;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public aspect RestAspect {
    private Logger LOGGER = LoggerFactory.getLogger(RestAspect.class);
    pointcut httpExecute():call(org.apache.http.client.methods.CloseableHttpResponse execute(..));

    before():httpExecute(){
        LOGGER.warn("***   @Aspectj   ***");
    }
}
