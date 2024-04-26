package org.example.flux;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.TestComponent;
import reactor.core.Disposable;
import reactor.core.publisher.Flux;

import java.time.Duration;

@Slf4j
@TestComponent
class FluxTest {
    @Test
    void test4() {
        Flux<String> flux1 = Flux.just("2", "3");
        Flux<String> flux2 = Flux.just("qwer", "asdf", "zxcv")
                .doOnNext(x -> log.info("{}", x));

        flux1.mergeWith(flux2).map(x -> x.concat(" "))
                .subscribe(System.out::print);
        System.out.println();
        flux1.zipWith(flux2).subscribe(System.out::print);
        System.out.println();
    }

    @Test
    void test3() {
        Flux.just(2, 3, 4, 5, 7, 8, 9, 0)
                .skip(1)
                .take(2)
                .subscribe(System.out::println);

        Disposable disposable = Flux.just("qwer", "asdf", "zxcv")
                .flatMap(x -> Flux.fromArray(x.split("")))
                .map(String::toUpperCase)
                .subscribe(
                        value -> System.out.println("Received: " + value),
                        error -> System.err.println("Error: " + error),
                        () -> System.out.println("Stream completed")
                );
        disposable.dispose();
    }

    @Test
    void test2() {
        Disposable disposable = Flux.just("aaa", "bbb", "ccc")
                .log()
                .map(String::toUpperCase)
                .log()
                .subscribe(x -> log.info("{}", x));
        disposable.dispose();
        System.out.println();
    }

    @Test
    void test1() throws InterruptedException {
        Flux.just(2, 3, 4, 5, 7, 8, 9, 0)
                .delayElements(Duration.ofSeconds(2))
                .map(x -> x * x)
                .subscribe(x -> log.info("{}", x));
        Thread.sleep(100000);
    }
}
