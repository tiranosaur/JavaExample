package com.example.server.controller;

import com.example.server.model.Greeting;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Slf4j
@Controller
public class GreetingServerController {
    private static final Random random = new Random();

    @MessageMapping("test")
    public Mono<String> test() {
        log.info("   ***   Received test");
        return Mono.just("***   tested   ***");
    }

    @MessageMapping("test-string")
    public Mono<String> testString(Mono<String> ping) {
        log.info("   ***   Received test-string {}", ping);
        return Mono.just("***   pong   ***");
    }

    @MessageMapping("hello")
    public Mono<String> hello(Greeting greeting) {
        log.info("   ***   received hello - {} at {}", greeting, Instant.now());
        greeting.setMessage(String.format("***   %s   ***", greeting.getMessage()));
        return Mono.just(greeting.getMessage());
    }

    @MessageMapping("greet.{name}")
    public Mono<String> greet(@DestinationVariable String name, @Payload Greeting greeting) {
        log.info("   ***   received greet.{name} - {}, {} at {}", name, greeting, Instant.now());
        return Mono.just(String.format("Hello %s, %s at %s", name, greeting.getMessage(), Instant.now()));
    }

    @MessageMapping("greet-stream")
    public Flux<String> greetStream(@Payload Greeting greeting) {
        log.info("   ***   received greet-stream - {} at {}", greeting, Instant.now());
        return Flux.interval(Duration.ofSeconds(1))
                .map(i -> String.format("greet-stream#(Hello #%s, %s) at %s", i, greeting.getMessage(), Instant.now()));
    }

    @MessageMapping("greet-channel")
    public Flux<String> greetChannel(@Payload Flux<Greeting> greetingFlux) {
        log.info("   ***   received greet-channel -  {} at {}", greetingFlux, Instant.now());
        return greetingFlux.delayElements(Duration.ofSeconds(1))
                .map(m -> String.format("greet-channel# (%s) at %s", m, Instant.now()));
    }

    @MessageMapping("numbers-stream")
    public Flux<String> numbersChannel() {
        log.info("   ***   received numbers-channel - at {}", Instant.now());

        List<Integer> randomNumbersList = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            int randomNumber = random.nextInt();
            randomNumbersList.add(randomNumber);
        }

        return Flux.fromIterable(randomNumbersList)
                .concatMap(number -> Mono.just(number).delayElement(Duration.ofSeconds(1)).map(m -> String.format("numbers-stream# %d", number)));
    }
}