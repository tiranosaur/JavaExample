package com.example.spring.configuration;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class S3ClientConfiguration {


    @Value("${s3.key}")
    private String apiKey;

    @Value("${s3.secret}")
    private String apiSecret;

    @Value("${s3.endpoint}")
    private String endpoint;

    @Value("${s3.timeout}")
    private int timeout;

    @Value("${s3.location}")
    private String location;

    @Bean
    @Scope("prototype")
    public AmazonS3 amazonS3() {
        AWSCredentials credentials = new BasicAWSCredentials(apiKey, apiSecret);
        ClientConfiguration clientConfig = new ClientConfiguration().withRequestTimeout(timeout);
        clientConfig.setUseTcpKeepAlive(true);

        return AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(endpoint, ""))
                .withPathStyleAccessEnabled(true)
                .withClientConfiguration(clientConfig).build();
    }
}