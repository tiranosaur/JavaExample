package com.example.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.rsocket.RSocketRequester;
import org.springframework.messaging.rsocket.annotation.ConnectMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Controller
@Slf4j
class GreetingController {
    private final Map<String, RSocketRequester> REQESTER_MAP = new HashMap<>();

    @ConnectMapping("connect")
    public void connect(RSocketRequester requester, @Payload String user) {
        log.info("@ConnectMapping(connect), user:{}", user);
        requester.rsocket()
                .onClose()
                .doFinally(
                        f -> REQESTER_MAP.remove(user, requester)
                );
        REQESTER_MAP.put(user, requester);
        log.info("send status back to client...");
        requester.route("status").data("user:" + user + " is connected!")
                .retrieveMono(String.class)
                .subscribe(
                        data -> log.info("received data from the client: {}", data),
                        error -> log.error("error: {}", error),
                        () -> log.info("done")
                );
    }

    @MessageMapping("ping")
    public Mono<String> ping(@Payload String message) {
        log.info("@MessageMapping(hello), payload : {}", message);
        return Mono.just("ping received (" + message + ") at " + LocalDateTime.now());
    }
}
