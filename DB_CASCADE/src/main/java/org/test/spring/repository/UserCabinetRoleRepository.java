package org.test.spring.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.test.spring.entity.Cabinet;
import org.test.spring.entity.UserCabinetRole;

@Repository
public interface UserCabinetRoleRepository extends JpaRepository<UserCabinetRole, Long> {
}
