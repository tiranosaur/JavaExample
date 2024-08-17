package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;

    @Enumerated(EnumType.STRING)
    @Column(name = "sex", nullable = false)
    private UserSex userSex = UserSex.MAN;

    @JsonManagedReference
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<Role> roleList = new ArrayList<>();

    @JsonManagedReference
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Post post;

    public User(Long id, String name, int age, UserSex userSex) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.userSex = userSex;
    }

    public User(Long id, String name, int age, UserSex userSex, List<Role> roleList) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.userSex = userSex;
        this.roleList = roleList;
    }

    public User(Long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
