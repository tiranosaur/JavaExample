package org.example.flux.service;

import org.example.flux.model.TestModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class TestService {
    private WebClient webClient;

    @Value("${service.url}")
    private String url;

    public TestService(WebClient webClient) {
        this.webClient = webClient;
    }

    public Mono<TestModel> test() {
        return webClient
                .get()
                .uri(url)
                .retrieve()
                .bodyToMono(TestModel.class);
    }
}
