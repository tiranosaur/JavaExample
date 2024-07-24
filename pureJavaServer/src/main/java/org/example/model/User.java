package org.example.model;

import org.example.util.UriUtil;

import java.util.UUID;

public class User {
    private UUID id;
    private String name;
    private Integer age;

    public User() {
    }

    public User(UUID id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public User(Object id, String name, Integer age) {
        this.id = UriUtil.getUUID(id);
        this.name = name;
        this.age = age;
    }

    public synchronized UUID getId() {
        return id;
    }

    public synchronized void setId(UUID id) {
        this.id = id;
    }

    public synchronized String getName() {
        return name;
    }

    public synchronized void setName(String name) {
        this.name = name;
    }

    public synchronized Integer getAge() {
        return age;
    }

    public synchronized void setAge(Integer age) {
        this.age = age;
    }
}
