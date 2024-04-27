package org.example.flux;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.ArrayList;

@Slf4j
@SpringBootApplication
public class FluxApplication {

    public static void main(String[] args) throws InterruptedException {
        ArrayList<Xxx> list = new ArrayList<>();
        list.add(new Xxx(1));
        list.add(new Xxx(2));
        list.add(new Xxx(13));
        list.add(new Xxx(14));
        list.add(new Xxx(15));
//        SpringApplication.run(FluxApplication.class, args);
        Flux.fromIterable(list)
                .doOnNext(s -> s.x = s.x * 345)
                .subscribe(x -> System.out.println(x.x));
    }

}

class Xxx {
    public int x;

    public Xxx(int x) {
        this.x = x;
    }
}