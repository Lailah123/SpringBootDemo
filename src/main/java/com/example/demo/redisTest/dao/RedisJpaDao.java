package com.example.demo.redisTest.dao;

import com.example.demo.redisTest.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RedisJpaDao extends JpaRepository<User,Integer> {

    void deleteById(Integer id);

    List<User> findAll();
}
