package com.example.demo.service;

import com.example.demo.model.Role;
import com.example.demo.model.User;
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
    private UserRepository userRepository;
    private UserRepo userRepo;
    private RoleRepository roleRepository;

    public UserService(UserRepository userRepository, UserRepo userRepo, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.userRepo = userRepo;
        this.roleRepository = roleRepository;
    }

    @PostConstruct
    public void init() {
        if (userRepository.count() == 0) {
            Role adminRole = new Role(1L, "ADMIN");
            Role userRole = new Role(2L, "USER");
            Role managerRole = new Role(3L, "MANAGER");
            roleRepository.save(adminRole);
            roleRepository.save(userRole);
            roleRepository.save(managerRole);

            List<User> userList = new ArrayList<>();
            userList.add(new User(1L, "Alice", 25, List.of(managerRole, adminRole)));
            userList.add(new User(2L, "Bob", 30, List.of(adminRole)));
            userList.add(new User(3L, "Charlie", 28));
            userRepository.saveAll(userList);
        }
    }

    @EventListener(ApplicationReadyEvent.class)
    public void applicationReady() throws JsonProcessingException {
        userRepository.deleteRole(1L, 1L);
        userRepository.insertRoles(1L, 1L);

        User user = userRepository.findById(1L).get();
        log.info("user: {}", objectMapper.writeValueAsString(user));

        System.out.println("222" + userRepository.getAll_annotation());
        System.out.println("111" + userRepository.findAll());
        System.out.println("333" + userRepo.getAll_query());
        System.out.println("444" + userRepo.getAll_criteria());
        System.out.println("555" + userRepo.getAll_jdbc());
    }
}
