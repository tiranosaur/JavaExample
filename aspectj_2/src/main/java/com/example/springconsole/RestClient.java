package com.example.springconsole;

import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

@Component
public class RestClient {
    public String getRequest() {
        try {
            RequestConfig config = RequestConfig.custom()
                    .setConnectTimeout(10000)
                    .setConnectionRequestTimeout(10000)
                    .build();
            CloseableHttpClient httpClient = HttpClientBuilder.create().setDefaultRequestConfig(config).build();
            //CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpGet uploadFile = new HttpGet("https://tools.learningcontainer.com/sample-json-file.json");

            CloseableHttpResponse response = httpClient.execute(uploadFile);
            HttpEntity responseEntity = response.getEntity();

            String responseString = EntityUtils.toString(responseEntity, "UTF-8");
            httpClient.close();
            return responseString;
        } catch (Exception e) {
            return null;
        }
    }
}
