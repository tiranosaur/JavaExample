package org.example.flux;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.publisher.Flux;

import java.time.Duration;

@Slf4j
@SpringBootApplication
public class FluxApplication {

    public static void main(String[] args) throws InterruptedException {

        SpringApplication.run(FluxApplication.class, args);
    }

}
