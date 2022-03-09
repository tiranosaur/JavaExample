package com.example.springconsole.repository;

import com.example.springconsole.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
//    @Query("select  u from User u where u.name = ?1")
    User findByUsername(String name);
    User findByPassword(String password);
}
