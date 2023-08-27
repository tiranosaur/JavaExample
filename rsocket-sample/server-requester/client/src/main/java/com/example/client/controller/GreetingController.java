package com.example.client.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.rsocket.RSocketRequester;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequiredArgsConstructor
class GreetingController {
    private final RSocketRequester requester;

    @GetMapping("ping")
    Mono<String> ping() {
        return this.requester.route("ping").data("ping RSocket").retrieveMono(String.class);
    }
}
