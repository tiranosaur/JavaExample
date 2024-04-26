package org.example.flux.repository;

import org.example.flux.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class UserRepository {
    private List<User> userList = List.of(
            new User(UUID.fromString("00000000-0000-0000-0000-000000000001"), "alice", 87, "alice_random@email.com"),
            new User(UUID.fromString("00000000-0000-0000-0000-000000000002"), "bob", 43, "bob_random@email.com"),
            new User(UUID.fromString("00000000-0000-0000-0000-000000000003"), "charlie", 15, "charlie_random@email.com"),
            new User(UUID.fromString("00000000-0000-0000-0000-000000000004"), "david", 22, "david_random@email.com"),
            new User(UUID.fromString("00000000-0000-0000-0000-000000000005"), "emma", 34, "emma_random@email.com"),
            new User(UUID.fromString("00000000-0000-0000-0000-000000000006"), "frank", 18, "frank_random@email.com"),
            new User(UUID.fromString("00000000-0000-0000-0000-000000000007"), "grace", 25, "grace_random@email.com"),
            new User(UUID.fromString("00000000-0000-0000-0000-000000000008"), "henry", 28, "henry_random@email.com"),
            new User(UUID.fromString("00000000-0000-0000-0000-000000000009"), "ivy", 44, "ivy_random@email.com"),
            new User(UUID.fromString("00000000-0000-0000-0000-000000000010"), "jack", 57, "jack_random@email.com")
    );

    public List<User> getAll() {
        return userList;
    }

    public User getById(UUID id) {
        return userList.stream()
                .filter(user -> user.getUuid().equals(id))
                .findFirst().orElse(null);
    }
}
