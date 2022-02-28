package com.example.redisjava.repository.Impl;


import com.example.redisjava.models.Student;
import com.example.redisjava.repository.RedisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Map;

@Repository
public class RedisStudentRepository implements RedisRepository {
    private static final String KEY = "Student";
    private RedisTemplate<String, Object> redisTemplate;
    private HashOperations hashOperations;

    @Autowired
    public RedisStudentRepository(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @PostConstruct
    private void init() {
        hashOperations = redisTemplate.opsForHash();
    }

    public void add(final Student student) {
        hashOperations.put(KEY, student.getId(), student.getName());
    }

    public void delete(final String id) {
        hashOperations.delete(KEY, id);
    }

    public Student findById(final String id) {
        return (Student) hashOperations.get(KEY, id);
    }

    public Map<Object, Object> findAll() {
        return hashOperations.entries(KEY);
    }
}