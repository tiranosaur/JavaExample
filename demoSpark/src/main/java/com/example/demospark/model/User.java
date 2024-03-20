package com.example.demospark.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(setterPrefix = "set")
public class User implements Serializable {
    private UUID id;
    private String name;
    private String sex;
    private int age;

    public static User mapFromCSV(String str) {
        String[] parts = str.split(",");
        return User.builder()
                .setId(UUID.fromString(parts[0]))
                .setName(parts[1])
                .setSex(parts[2])
                .setAge(Integer.parseInt(parts[3]))
                .build();
    }
}
