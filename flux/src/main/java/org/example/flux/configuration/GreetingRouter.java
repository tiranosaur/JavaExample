package org.example.flux.configuration;

import org.example.flux.handler.GreetingHandler;
import org.example.flux.handler.UserHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.*;
import reactor.core.publisher.Flux;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration(proxyBeanMethods = false)
public class GreetingRouter {
    @Bean
    public RouterFunction<ServerResponse> route(GreetingHandler greetingHandler, UserHandler userHandler) {
        RequestPredicate route = RequestPredicates
                .GET("/func")
                .and(RequestPredicates.accept(MediaType.APPLICATION_JSON));

        return RouterFunctions
                .route(route, userHandler::getAll)
                .andRoute(GET("user").and(accept(MediaType.APPLICATION_JSON)), userHandler::get)
                .andRoute(GET("hello").and(accept(MediaType.APPLICATION_JSON)), greetingHandler::greet);
    }
}