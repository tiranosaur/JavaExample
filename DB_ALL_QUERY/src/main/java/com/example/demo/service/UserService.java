package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepo;
import com.example.demo.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class UserService {
    private UserRepository userRepository;
    private UserRepo userRepo;

    public UserService(UserRepository userRepository, UserRepo userRepo) {
        this.userRepository = userRepository;
        this.userRepo = userRepo;
    }

    @PostConstruct
    public void init() {
        if (userRepository.count() == 0) {
            List<User> userList = new ArrayList<>();
            userList.add(new User(1L, "Alice", 25));
            userList.add(new User(2L, "Bob", 30));
            userList.add(new User(3L, "Charlie", 28));
            userList.add(new User(4L, "Diana", 35));
            userList.add(new User(5L, "Eve", 22));
            userList.add(new User(6L, "Frank", 27));
            userList.add(new User(7L, "Grace", 31));
            userList.add(new User(8L, "Hannah", 29));
            userList.add(new User(9L, "Ian", 26));
            userList.add(new User(10L, "Jack", 33));
            userRepository.saveAll(userList);
        }
    }

    @EventListener(ApplicationReadyEvent.class)
    public void applicationReady() {
        System.out.println("111" + userRepository.findAll());
        System.out.println("222" + userRepository.getAll_annotation());
        System.out.println("333" + userRepo.getAll_query());
        System.out.println("444" + userRepo.getAll_criteria());
        System.out.println("555" + userRepo.getAll_jdbc());
    }
}
