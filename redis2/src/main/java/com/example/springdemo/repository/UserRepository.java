package com.example.springdemo.repository;

import com.example.springdemo.model.User;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.UUID;

@Repository
public class UserRepository {
    private List<User> users;

    @PostConstruct
    public void init(){
        users = List.of(
           new User(UUID.randomUUID(), "FirstName", 33)    ,
           new User(UUID.randomUUID(), "SecondName", 11)   ,
           new User(UUID.randomUUID(), "ThirdName", 87)
        );
    }

    public List<User> findAll(){
        return users;
    }
}
