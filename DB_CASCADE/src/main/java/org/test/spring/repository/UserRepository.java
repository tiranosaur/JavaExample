package org.test.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.test.spring.entity.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
