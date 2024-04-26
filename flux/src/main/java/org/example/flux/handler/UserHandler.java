package org.example.flux.handler;

import lombok.extern.slf4j.Slf4j;
import org.example.flux.model.User;
import org.example.flux.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class UserHandler {
    private final UserRepository userRepository;

    @Autowired
    public UserHandler(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Mono<ServerResponse> getAll(ServerRequest serverRequest) {
        Flux<User> result = Flux.fromIterable(userRepository.getAll())
                .doOnNext(x -> x.setAge(x.getAge() * 3));

        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(result, User.class);
    }

    public Mono<ServerResponse> get(ServerRequest serverRequest) {
        Map<String, String> params = serverRequest.queryParams().toSingleValueMap();

        UUID uuid = Optional.ofNullable(params.get("id"))
                .map(UUID::fromString)
                .orElse(null);

        User user = userRepository.getById(uuid);

        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.justOrEmpty(user), User.class);
    }
}
