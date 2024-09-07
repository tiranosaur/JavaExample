package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@Builder(setterPrefix = "set")
@NoArgsConstructor
@Entity(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "username")
    private String username;

    @Column(name = "age")
    private int age;

    @Column(
            name = "created_at",
            nullable = false,
            updatable = false,
            insertable = false,
            columnDefinition = "TIMESTAMP(0) DEFAULT CURRENT_TIMESTAMP"
    )
    @CreationTimestamp
    private Timestamp createdAt;

    @Column(
            name = "updated_at",
            nullable = false,
            insertable = false,
            columnDefinition = "TIMESTAMP(0) DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP"
    )
    @UpdateTimestamp
    private Timestamp updatedAt;

    @Enumerated(EnumType.STRING)
    @Column(name = "sex", nullable = false)
    private UserSex sex = UserSex.MAN;

    @JsonManagedReference
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "user_role",
            // foreign key need for on delete cascade (DatabaseSetupConfig)
            joinColumns = @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "fk_user")),
            // foreign key need for on delete cascade (DatabaseSetupConfig)
            inverseJoinColumns = @JoinColumn(name = "role_id", foreignKey = @ForeignKey(name = "fk_role"))
    )
    @Builder.Default
    private List<Role> roleList = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "line_first_user",
            // foreign key need for on delete cascade (DatabaseSetupConfig)
            joinColumns = @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "fk_line_first_user_id")),
            // foreign key need for on delete cascade (DatabaseSetupConfig)
            inverseJoinColumns = @JoinColumn(name = "line_id", foreignKey = @ForeignKey(name = "fk_first_line_id_user"))
    )
    @Builder.Default
    private List<LineFirst> lineFirstList = new ArrayList<>();

    public User(UUID id, String name, int age) {
        this.id = id;
        this.username = name;
        this.age = age;
    }
}
