package com.example.springdemo.repository;

import com.example.springdemo.Main;
import com.example.springdemo.model.User;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.time.Duration;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

@Slf4j
@Repository
public class UserRepository {
    private List<User> users;

    @PostConstruct
    public void init() {
        users = List.of(
                new User(UUID.randomUUID(), "FirstName", 33),
                new User(UUID.randomUUID(), "SecondName", 11),
                new User(UUID.randomUUID(), "ThirdName", 87)
        );
    }

    public final LoadingCache<String, List<User>> loadingCache = CacheBuilder.newBuilder()
            .expireAfterAccess(Duration.ofSeconds(3))
            .build(new CacheLoader<>() {
                @Override
                public List<User> load(String key) {
                    return delay();
                }
            });

    public List<User> findAll() {
        try {
            return loadingCache.get(Main.name);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    private List<User> delay() {
        log.error("start");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        log.error("finish");
        return users;
    }
}
