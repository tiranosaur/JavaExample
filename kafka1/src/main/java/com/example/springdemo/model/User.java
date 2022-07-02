package com.example.springdemo.model;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
    private UUID id;
    private String name;
    private int age;
}
