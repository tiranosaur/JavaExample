package org.test.spring.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(
        name = "user_cabinet_role",
        uniqueConstraints = @UniqueConstraint(columnNames = {"role", "user_id", "cabinet_id"})
)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserCabinetRole {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OnDelete(action = OnDeleteAction.CASCADE) // all magic is here
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;

    @OnDelete(action = OnDeleteAction.CASCADE) // all magic is here
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cabinet_id", referencedColumnName = "id", nullable = false)
    private Cabinet cabinet;
}

