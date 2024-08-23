package com.example.demo.repository;

import com.example.demo.model.UserComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserCommentRepository extends JpaRepository<UserComment, UUID> {
}
