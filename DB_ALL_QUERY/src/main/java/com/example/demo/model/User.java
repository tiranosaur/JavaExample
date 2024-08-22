package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String username;

    private int age;

    @Enumerated(EnumType.STRING)
    @Column(name = "sex", nullable = false)
    private UserSex userSex = UserSex.MAN;

    @JsonManagedReference
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_role",
            // foreign key need for on delete cascade (DatabaseSetupConfig)
            joinColumns = @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "fk_user")),
            // foreign key need for on delete cascade (DatabaseSetupConfig)
            inverseJoinColumns = @JoinColumn(name = "role_id", foreignKey = @ForeignKey(name = "fk_role"))
    )
    private List<Role> roleList = new ArrayList<>();

    @JsonManagedReference
    @OneToOne(
            mappedBy = "user",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    private Post post;

    @JsonManagedReference
    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    private List<UserComment> userCommentList = new ArrayList<>();

    public User(UUID id, String name, int age, UserSex userSex) {
        this.id = id;
        this.username = name;
        this.age = age;
        this.userSex = userSex;
    }

    public User(UUID id, String name, int age, UserSex userSex, List<Role> roleList) {
        this.id = id;
        this.username = name;
        this.age = age;
        this.userSex = userSex;
        this.roleList = roleList;
    }

    public User(UUID id, String name, int age) {
        this.id = id;
        this.username = name;
        this.age = age;
    }
}
