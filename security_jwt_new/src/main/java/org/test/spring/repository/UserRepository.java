package org.test.spring.repository;

import jakarta.annotation.PostConstruct;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.test.spring.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {
    private List<User> userList = new ArrayList<User>();

    @PostConstruct
    public void init() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String pass = encoder.encode("Pass123");
        userList.add(new User(1L, "admin", pass, List.of("ROLE_ADMIN", "ROLE_USER")));
        userList.add(new User(2L, "user", pass, List.of("ROLE_USER")));
    }

    public Optional<User> findByLogin(String username) {
        for (User user : userList) {
            if (user.getUsername().equals(username)) {
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }
}
