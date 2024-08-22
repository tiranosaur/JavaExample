package com.example.demo.service;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Slf4j
@Service
public class UserService {
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final Random random = new Random();
    private final UserRepository userRepository;
    private final UserRepo userRepo;
    private final RoleRepository roleRepository;
    private final PostRepository postRepository;
    private final UserCommentRepository userCommentRepository;

    public UserService(
            UserRepository userRepository,
            UserRepo userRepo,
            RoleRepository roleRepository,
            PostRepository postRepository,
            UserCommentRepository userCommentRepository
    ) {
        this.userRepository = userRepository;
        this.userRepo = userRepo;
        this.roleRepository = roleRepository;
        this.postRepository = postRepository;
        this.userCommentRepository = userCommentRepository;
    }

    @PostConstruct
    public void init() {
        if (userRepository.count() == 0) {
            Role adminRole = new Role(null, "ADMIN");
            Role userRole = new Role(null, "USER");
            Role managerRole = new Role(null, "MANAGER");
            roleRepository.saveAllAndFlush(List.of(adminRole, userRole, managerRole));

            User user1 = new User(null, "Alice", 25, UserSex.WOMAN, List.of(managerRole, adminRole));
            List<User> userList = new ArrayList<>();
            userList.add(user1);
            userList.add(new User(null, "Bob", 30, UserSex.MAN, List.of(adminRole)));
            userList.add(new User(null, "Charlie", 28, UserSex.MAN, List.of(userRole)));
            userList.add(new User(null, "Diana", 22, UserSex.WOMAN));
            userList.add(new User(null, "Eve", 27, UserSex.WOMAN, List.of(userRole, adminRole)));
            userList.add(new User(null, "Frank", 32, UserSex.MAN, List.of(adminRole, managerRole)));
            userList.add(new User(null, "Grace", 29));
            userList.add(new User(null, "Hank", 35, UserSex.MAN, List.of(adminRole, userRole)));
            userList.add(new User(null, "Ivy", 31, UserSex.WOMAN, List.of(userRole)));
            userList.add(new User(null, "Jack", 26, UserSex.MAN, List.of(managerRole, userRole)));
            userList = userRepository.saveAllAndFlush(userList);

            user1.setId(userList.get(0).getId());

            List<Post> postList = new ArrayList<>();
            postList.add(new Post(null, "Random post title 2", userList.get(1)));
            postList.add(new Post(null, "Random post title 1", user1));
            postRepository.saveAllAndFlush(postList);

            List<UserComment> userCommentList = new ArrayList<>();
            User userWithComment = userList.get(0);
            userCommentList.add(new UserComment(null, "lskdjflskdjflskdfjlskdjf", userWithComment));
            userCommentList.add(new UserComment(null, "1", userWithComment));
            userCommentList.add(new UserComment(null, "2", userWithComment));
            userCommentList.add(new UserComment(null, "33333333333333", userWithComment));
            userCommentList.add(new UserComment(null, "4444444444444", userWithComment));
            userCommentList.add(new UserComment(null, "5555", userWithComment));
            userCommentList.add(new UserComment(null, "66666666666666666666", userWithComment));
            userCommentRepository.saveAllAndFlush(userCommentList);
        }
    }


    @EventListener(ApplicationReadyEvent.class)
    public void applicationReady() {
        test1();
        test2();
        test3();
        test4();
    }


    private void test1() {
        System.out.println("\n\n\n===========================================test1");
        User user1 = new User(null, "Skuf", 234);
        User user2 = userRepository.findByUsername("Alice").orElseThrow(RuntimeException::new);
        user2.setAge(random.nextInt());
        userRepository.saveAll(List.of(user1, user2));
        userRepository.delete(userRepository.findByUsername("Skuf").orElseThrow(RuntimeException::new));
    }

    private void test2() {
        System.out.println("\n\n\n===========================================test2");
        User user1 = userRepository.findByUsername("Alice").orElseThrow(RuntimeException::new);
        User user2 = userRepository.findByUsername("Bob").orElseThrow(RuntimeException::new);
        Role role = roleRepository.findByName("ADMIN").orElseThrow(RuntimeException::new);

        userRepository.deleteRole(user1.getId(), role.getId());
        userRepository.insertRoles(user1.getId(), role.getId());

        User user3 = userRepository.findByUsername("Charlie").get();
        User user4 = userRepository.findByUsername("Diana").get();

        log.info("user1: {}", user3);
        log.info("user list: {}", new ArrayList<>(List.of(user3, user4)));
    }

    private void test3() {
        System.out.println("\n\n\n===========================================test3");
//        log.info("222 [{}]", userRepository.getAllWithEntityGraph());
        System.out.println("\n\n111" + userRepository.findAll());
        System.out.println("\n\n333" + userRepo.getAll_query());
        System.out.println("\n\n444" + userRepo.getAll_criteria());
        System.out.println("\n\n555" + userRepo.getAll_jdbc());
    }

    private void test4() {
        System.out.println("\n\n\n===========================================test4");
        User user = userRepository.findByUsername("Alice").orElseThrow(RuntimeException::new);
        userRepository.delete(user);
    }
}
