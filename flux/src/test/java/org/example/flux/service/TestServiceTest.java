package org.example.flux.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.example.flux.model.TestModel;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.io.IOException;

public class TestServiceTest {
    private static final ObjectMapper mapper = new ObjectMapper();
    private static MockWebServer mockWebServer;
    private static TestService service;

    @BeforeAll
    static void setUp() throws IOException {
        mockWebServer = new MockWebServer();
        mockWebServer.start();
        WebClient mockedWebClient = WebClient.builder()
                .baseUrl(mockWebServer.url("/").toString())
                .build();

        service = new TestService(mockedWebClient);
    }

    @AfterAll
    static void tearDown() throws IOException {
        mockWebServer.shutdown();
    }


    @Test
    void test_fail() throws JsonProcessingException {
        mockWebServer.enqueue(
                new MockResponse().setResponseCode(HttpStatus.OK.value())
                        .setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                        .setBody(mapper.writeValueAsString(getResponse()))
        );

        Mono<TestModel> result = service.test();

        StepVerifier.create(result)
                .expectNextMatches(actualResponse -> {
                    return !actualResponse.getColor().equals("asdfa") &&
                            !actualResponse.getFruit().equals("fdtyjdetyhsrt") &&
                            !actualResponse.getSize().equals("547ujer6th");
                })
                .verifyComplete();
    }

    @Test
    void test_success() throws JsonProcessingException {
        mockWebServer.enqueue(
                new MockResponse().setResponseCode(HttpStatus.OK.value())
                        .setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                        .setBody(mapper.writeValueAsString(getResponse()))
        );

        Mono<TestModel> result = service.test();

        StepVerifier.create(result)
                .expectNextMatches(actualResponse -> {
                    return actualResponse.getColor().equals("yellow") &&
                            actualResponse.getFruit().equals("fig") &&
                            actualResponse.getSize().equals("big");
                })
                .verifyComplete();
    }

    private static TestModel getResponse() {
        TestModel response = new TestModel();
        response.setFruit("fig");
        response.setColor("yellow");
        response.setSize("big");
        return response;
    }
}
