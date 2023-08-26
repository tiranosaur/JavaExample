package com.example.server.controller;

import com.example.server.model.Greeting;
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
    public String test() {
        log.info("   ***   Received test");
        return "tested";
    }

    @MessageMapping("test-string")
    public Mono<String> testString(Mono<String> ping) {
        log.info("   ***   Received test-string {}", ping);
        return Mono.just("pong");
    }

    @MessageMapping("hello")
    public Mono<Void> hello(Greeting p) {
        log.info("   ***   received hello - {} at {}", p, Instant.now());
        return Mono.empty();
    }

    @MessageMapping("greet.{name}")
    public Mono<String> greet(@DestinationVariable String name, @Payload Greeting p) {
        log.info("   ***   received greet.{name} - {}, {} at {}", name, p, Instant.now());
        return Mono.just(String.format("Hello %s, %s at %s", name, p.getMessage(), Instant.now()));
    }

    @MessageMapping("greet-stream")
    public Flux<String> greetStream(@Payload Greeting p) {
        log.info("   ***   received greet-stream - {} at {}", p, Instant.now());
        return Flux.interval(Duration.ofSeconds(1))
                .map(i -> String.format("greet-stream#(Hello #%s, %s) at %s", i, p.getMessage(), Instant.now()));
    }

    @MessageMapping("greet-channel")
    public Flux<String> greetChannel(@Payload Flux<Greeting> p) {
        log.info("   ***   received greet-channel -  {} at {}", p, Instant.now());
        return p.delayElements(Duration.ofSeconds(1))
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