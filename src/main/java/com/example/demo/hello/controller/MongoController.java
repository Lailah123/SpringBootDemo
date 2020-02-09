package com.example.demo.hello.controller;


import com.example.demo.hello.entity.User;
import com.example.demo.redisTest.util.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/api/v1")
@EnableAutoConfiguration
public class MongoController {

    private final Logger log = LoggerFactory.getLogger(MongoController.class);
    @Autowired
    MongoTemplate mongotemplate;
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Autowired
    RedisTemplate redisTemplate;
    @Resource
    private RedisUtil redisUtil;

    @RequestMapping("/mongo/query")
    @ResponseBody
    public List<User> query() {
        // 匹配条件sex = 男
        Criteria criteria = Criteria.where("sex").is("男");
        Query query = Query.query(criteria);

        // 查询名字为张三的所有学生
        List<User> students = mongotemplate.find(query, User.class);

        // 类似的 查询年龄 > 18的学生
//        Criteria criteria1 = Criteria.where("age").lt(18);
//        Query query1 = Query.query(criteria);
//        List<User> students1 = mongotemplate.find(query1, User.class);
        return students;
    }


    @RequestMapping(value = "/mongo/save", method = RequestMethod.GET)
    public void save() {
        User student = new User();
        for (int i = 0; i < 20; i++) {
            student.setName("张三");
            student.setAge(i);
            student.setSex("男");
            student.setId(UUID.randomUUID().toString());
            mongotemplate.save(student);
            log.info("Mongo插入第{}",i);
        }

//        student.setName("张三");
//        student.setAge(18);
//        student.setSex("男");
//        student.setId(UUID.randomUUID().toString());
    }
    @RequestMapping(value = "/mongo/queryByPage",method = RequestMethod.GET)
    @ResponseBody
    public List<User> queryByPage(){
        Pageable pageable = new PageRequest(1, 5);
        Query query = new Query();
        query.with(pageable);
        query.with(new Sort(Sort.Direction.DESC, "age"));
        //多个排序条件
//        query.with(new Sort(Sort.Direction.ASC, "age").and(new Sort(Sort.Direction.DESC, "date")));
        List<User> users = mongotemplate.find(query, User.class);
        log.info("分页查询");
        return users;
    }

    @RequestMapping("/mongo/getCount")
    @ResponseBody
    public long getCount() {
        //Criteria（条件）
        Criteria criteria = Criteria.where("age").gt(10);
        //query方法为static方法，可以直接通过类名调用
        Query query = Query.query(criteria);
        long count = mongotemplate.count(query,User.class);
        log.info("获取条件删选数目");
        return count;
    }

    @RequestMapping("/redis/insert")
    public void redisTest() {
        redisUtil.set("bbb", "张三");
//        stringRedisTemplate.opsForValue().set("ccc","张三");
//        stringRedisTemplate.opsForValue().set("aaa", "123");
        log.info("redis插入数据");
    }

    @RequestMapping("/redis/get")
    @ResponseBody
    public String redisGet() {
        String bbb = redisUtil.get("aaa");
        log.info("redis读取数据");
        return bbb;
    }
}
