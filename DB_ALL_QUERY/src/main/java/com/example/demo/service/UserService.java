package com.example.demo.service;

import com.example.demo.model.Post;
import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.model.UserSex;
import com.example.demo.repository.PostRepository;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepo;
import com.example.demo.repository.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private final UserRepository userRepository;
    private final UserRepo userRepo;
    private final RoleRepository roleRepository;
    private final PostRepository postRepository;

    public UserService(UserRepository userRepository, UserRepo userRepo, RoleRepository roleRepository, PostRepository postRepository) {
        this.userRepository = userRepository;
        this.userRepo = userRepo;
        this.roleRepository = roleRepository;
        this.postRepository = postRepository;
    }

    @PostConstruct
    public void init() {
        if (userRepository.count() == 0) {
            Role adminRole = new Role(null, "ADMIN");
            Role userRole = new Role(null, "USER");
            Role managerRole = new Role(null, "MANAGER");
            roleRepository.saveAll(List.of(adminRole, userRole, managerRole));

            List<User> userList = new ArrayList<>();
            userList.add(new User(null, "Alice", 25, UserSex.WOMAN, List.of(managerRole, adminRole)));
            userList.add(new User(null, "Bob", 30, UserSex.MAN, List.of(adminRole)));
            userList.add(new User(null, "Charlie", 28, UserSex.MAN, List.of(userRole)));
            userList.add(new User(null, "Diana", 22, UserSex.WOMAN));
            userList.add(new User(null, "Eve", 27, UserSex.WOMAN, List.of(userRole, adminRole)));
            userList.add(new User(null, "Frank", 32, UserSex.MAN, List.of(adminRole, managerRole)));
            userList.add(new User(null, "Grace", 29));
            userList.add(new User(null, "Hank", 35, UserSex.MAN, List.of(adminRole, userRole)));
            userList.add(new User(null, "Ivy", 31, UserSex.WOMAN, List.of(userRole)));
            userList.add(new User(null, "Jack", 26, UserSex.MAN, List.of(managerRole, userRole)));
            userRepository.saveAllAndFlush(userList);

            User user1 = userRepository.findById(1L).orElseThrow(RuntimeException::new);
            List<Post> postList = new ArrayList<>();
            postList.add(new Post(null, "Random post title 2", userList.get(1)));
            postList.add(new Post(null, "Random post title 1", user1));
            postRepository.saveAll(postList);
        }
    }


    @EventListener(ApplicationReadyEvent.class)
    public void applicationReady() throws JsonProcessingException {
        userRepository.deleteRole(1L, 1L);
        userRepository.insertRoles(1L, 1L);

        User user1 = userRepository.findById(1L).get();
        User user2 = userRepository.findById(2L).get();
        log.info("user1: {}", objectMapper.writeValueAsString(user1));
        log.info("user list: {}", new ArrayList<>(List.of(user1, user2)));

        log.info("222 [{}]", userRepository.getAllAnnotation());
        System.out.println("111" + userRepository.findAll());
        System.out.println("333" + userRepo.getAll_query());
        System.out.println("444" + userRepo.getAll_criteria());
        System.out.println("555" + userRepo.getAll_jdbc());
    }
}
