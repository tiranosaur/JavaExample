package com.example.springdemo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class User implements Serializable {
    private UUID id;
    private String name;
    private int age;
}
