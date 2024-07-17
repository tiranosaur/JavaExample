package com.example.demo.service;

import com.example.demo.repository.UserRepo;
import com.example.demo.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MainService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserRepo userRepo;

    @EventListener(ApplicationReadyEvent.class)
    public void applicationReady() {
        System.out.println("111" + userRepository.findAll());
        System.out.println("222" + userRepository.getAll_annotation());
        System.out.println("333" + userRepo.getAll_query());
        System.out.println("444" + userRepo.getAll_criteria());
        System.out.println("555" + userRepo.getAll_jdbc());
    }
}
