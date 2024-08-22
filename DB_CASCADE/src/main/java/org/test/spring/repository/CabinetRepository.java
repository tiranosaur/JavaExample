package org.test.spring.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.test.spring.entity.Cabinet;

@Repository
public interface CabinetRepository extends JpaRepository<Cabinet, Long> {
}
