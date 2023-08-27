package com.example.client.configuration;

import com.example.client.handler.ClientHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.rsocket.RSocketRequester;
import org.springframework.messaging.rsocket.RSocketStrategies;
import org.springframework.messaging.rsocket.annotation.support.RSocketMessageHandler;
import org.springframework.util.MimeTypeUtils;

@Configuration
public class RSocketConfiguration {
    @Bean
    public RSocketRequester rSocketRequester(RSocketRequester.Builder builder, RSocketStrategies rSocketStrategies) {
        return builder.dataMimeType(MimeTypeUtils.APPLICATION_JSON)
                .rsocketFactory(RSocketMessageHandler.clientResponder(rSocketStrategies, new ClientHandler()))
                .setupRoute("connect")
                .setupData("user")
                .connectTcp("localhost", 7000)
                .block();
    }
}
