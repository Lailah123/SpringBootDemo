package com.example.demo.redisTest.controller;

import com.example.demo.redisTest.bean.User;
import com.example.demo.redisTest.service.RedisService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RedisControllerTest {

    @Autowired
    RedisService redisService;

    @RequestMapping("/redis/queryUser")
    @ResponseBody
    @Test
    public void queryUser() {
        System.out.println("666");
    }
}