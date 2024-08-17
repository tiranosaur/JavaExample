package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // выгружает сразу все сущности ролей. без использования дополнительных запросов
    @EntityGraph(attributePaths = {"roleList", "post"})
    @Query("select u from users u")
    List<User> getAllAnnotation();

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO user_role (user_id, role_id) VALUE (:user_id, :role_id)", nativeQuery = true)
    void insertRoles(@Param("user_id") Long user_id, @Param("role_id") Long role_id);

    @Modifying
    @Transactional
    @Query(value = "delete from user_role where user_id = :user_id and role_id = :role_id", nativeQuery = true)
    void deleteRole(@Param("user_id") Long user_id, @Param("role_id") Long role_id);

    @Query(value = "select u from users u where u.id = (select max(id) from users)")
    Optional<User> getLast();
}
