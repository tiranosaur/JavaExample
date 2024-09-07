package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder(setterPrefix = "set")
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "line_first")
public class LineFirst {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    private String name;

    @ManyToMany
    @JoinTable(
            name = "line_first_user",
            // foreign key need for on delete cascade (DatabaseSetupConfig)
            joinColumns = @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "fk_line_first_user_id")),
            // foreign key need for on delete cascade (DatabaseSetupConfig)
            inverseJoinColumns = @JoinColumn(name = "line_id", foreignKey = @ForeignKey(name = "fk_first_line_id_user"))
    )
    @Builder.Default
    private List<User> usersList = new ArrayList<>();

    @OneToMany(mappedBy = "lineFirst", cascade = CascadeType.ALL)
    private List<LineSecond> lineSecondList = new ArrayList<>();

    public LineFirst(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
