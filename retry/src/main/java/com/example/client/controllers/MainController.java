package com.example.client.controllers;

import com.example.client.services.RetryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class MainController {
    @Autowired
    RetryService retryService;

    @RequestMapping(value = "bad")
    public void bad() throws Exception{
        retryService.retry(false);
    }

    @RequestMapping(value = "good")
    public void good() throws Exception{
        retryService.retry(true);
    }
}
