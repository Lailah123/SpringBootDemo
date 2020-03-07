package com.example.demo.redisTest.dao;

import com.example.demo.redisTest.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RedisJpaDao extends JpaRepository<User,Integer> {

    public void deleteById(Integer id);
}
