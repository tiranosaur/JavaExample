package org.test.spring.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder(setterPrefix = "set")
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cabinets")
public class Cabinet {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name = null;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true, mappedBy = "cabinet",
            fetch = FetchType.EAGER,
            targetEntity = UserCabinetRole.class
    )
    private List<UserCabinetRole> userCabinetRoleList = new ArrayList<>();
}
