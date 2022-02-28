package com.example.redisjava.repository;



import com.example.redisjava.models.Student;

import java.util.Map;

public interface RedisRepository {
    Map<Object, Object> findAll();
    void add(Student movie);
    void delete(String id);
    Student findById(String id);
}