package com.example.client.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "xxxxxx", url = "https://filesamples.com/samples/code/json/")
public interface PublicFeignClient {
    @RequestMapping(method = RequestMethod.GET, value = "sample1.json")
    String getRequest();

    @RequestMapping(method = RequestMethod.GET, value = "sample2.json")
    String getRequest2();
}