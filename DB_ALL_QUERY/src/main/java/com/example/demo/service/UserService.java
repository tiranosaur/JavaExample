package com.example.demo.service;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.util.UserServiceUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

@Slf4j
@Service
public class UserService {
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final Random random = new Random();
    private final UserRepository userRepository;

    public UserService(
            UserRepository userRepository
    ) {
        this.userRepository = userRepository;
    }

    /*
    drop schema db_all_query;
    create schema db_all_query;
     */
    @PostConstruct
    public void init() {
        if (userRepository.count() == 0) {
            List<User> userList = UserServiceUtil.createUsers();

            List<Role> roleList = UserServiceUtil.createAndAttachRole(userList);
            List<LineFirst> lineFirstList = UserServiceUtil.createAndAttachLineFirst(userList);
            List<LineSecond> lineSecondList = UserServiceUtil.createAndAttachLineSecond(lineFirstList);

            userRepository.saveAllAndFlush(userList);
        }
    }


    @EventListener(ApplicationReadyEvent.class)
    public void applicationReady() {
//        test1();
//        test2();
//        test3();
//        test4();
    }


//    private void test1() {
//        System.out.println("\n\n\n===========================================test1");
//        User user1 = new User(null, "Skuf", 234);
//        User user2 = userRepository.findByUsername("Alice").orElseThrow(RuntimeException::new);
//        user2.setAge(random.nextInt());
//        userRepository.saveAll(List.of(user1, user2));
//        userRepository.delete(userRepository.findByUsername("Skuf").orElseThrow(RuntimeException::new));
//    }
//
//    private void test2() {
//        System.out.println("\n\n\n===========================================test2");
//        User user1 = userRepository.findByUsername("Alice").orElseThrow(RuntimeException::new);
//        User user2 = userRepository.findByUsername("Bob").orElseThrow(RuntimeException::new);
//        Role role = roleRepository.findByName("ADMIN").orElseThrow(RuntimeException::new);
//
//        userRepository.deleteRole(user1.getId(), role.getId());
//        userRepository.insertRoles(user1.getId(), role.getId());
//
//        User user3 = userRepository.findByUsername("Charlie").get();
//        User user4 = userRepository.findByUsername("Diana").get();
//
//        log.info("user1: {}", user3);
//        log.info("user list: {}", new ArrayList<>(List.of(user3, user4)));
//    }
//
//    private void test3() {
//        System.out.println("\n\n\n===========================================test3");
////        log.info("222 [{}]", userRepository.getAllWithEntityGraph());
//        System.out.println("\n\n111" + userRepository.findAll());
//        System.out.println("\n\n333" + userRepo.getAll_query());
//        System.out.println("\n\n444" + userRepo.getAll_criteria());
//        System.out.println("\n\n555" + userRepo.getAll_jdbc());
//    }
//
//    private void test4() {
//        System.out.println("\n\n\n===========================================test4");
//        User user = userRepository.findByUsername("Alice").orElseThrow(RuntimeException::new);
//        userRepository.delete(user);
//    }
}
