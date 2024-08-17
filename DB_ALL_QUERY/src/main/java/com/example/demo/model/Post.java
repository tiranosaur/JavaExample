package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String title;

    @JsonBackReference
    @JoinColumn
    @OneToOne(optional = false)
    private User user;

    @Override
    public String toString() {
        return "{\"id\"=" + id + ", \"title\"=\"" + title + "\"}";
    }
}
