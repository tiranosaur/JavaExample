package com.example.springdemo.service;

import com.example.springdemo.model.User;
import com.example.springdemo.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;


@RunWith(SpringRunner.class)
public class UserServiceTest {

    @Mock
    UserRepository userRepository;

    @Test
    public void getAll() {
        UUID uuid = UUID.randomUUID();
        User user = new User(uuid, "Vasia", 33);

        when(userRepository.findAll()).thenReturn(List.of(user));

        assertEquals(List.of(user), userRepository.findAll());
    }
}