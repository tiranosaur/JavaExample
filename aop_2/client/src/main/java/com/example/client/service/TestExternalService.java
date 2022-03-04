package com.example.client.service;

import com.utils.retryLibrary.annotation.ExceptRetry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.logging.Logger;

@Service
@Slf4j
public class TestExternalService {
    private int counter = 1;

//    @ExceptRetry
    public String test(boolean isSuccess) throws Exception {
        if (counter % 10 == 0 && isSuccess) {
            log.info("successful");
            return "HttpClientEmulator response";
        }

        log.info("run retry. counter = {}", counter++);
        throw new SQLException();
//        return null;
    }
}
