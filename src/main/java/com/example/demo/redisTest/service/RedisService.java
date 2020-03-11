package com.example.demo.redisTest.service;

import com.example.demo.annotation.Log;
import com.example.demo.redisTest.bean.User;
import com.example.demo.redisTest.dao.RedisDao;
import com.example.demo.redisTest.dao.RedisJpaDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class RedisService {
    private final Logger log = LoggerFactory.getLogger(RedisService.class);
    final
    RedisDao redisDao;
    final
    RedisJpaDao redisJpaDao;

    public RedisService(RedisDao redisDao, RedisJpaDao redisJpaDao) {
        this.redisDao = redisDao;
        this.redisJpaDao = redisJpaDao;
    }

    //    @Cacheable(cacheNames="userList", key="123")
//    可能会更新的数据不能用缓存
//    @Cacheable(cacheNames = "selectUser",key = "#id")
    public List<User> queryUser(Integer id) {
        log.info("直接查询,id为{}",id);
        return redisDao.queryUser(id);
    }
    //自定义注解，方法返回前
    @Log
    public int queryCount() {
        log.info("查询总条数");
        int count = redisDao.queryCount();
        return count;
    }
//    可能会更新的数据不能用缓存
//    @Cacheable(cacheNames = "pagerUser",key = "#currectPage")
    @Log
    public List<Map<String,Object>> queryByPage(Integer pageSize,Integer currectPage){
        log.info("直接查询,currectPage为{}",currectPage);
        List<Map<String, Object>> list = redisDao.queryByPage(pageSize, currectPage);
        return list;
    }

    public void insertUser(String name, String passWord) {
        redisDao.insertUser(name, passWord);
    }

    @Log
    public void deleteUser(Integer id) {
//        redisDao.deleteUser(id);
        redisJpaDao.deleteById(id);
    }

    public void editUser(String name, String passWord,Integer id) {
        redisDao.editUser(name, passWord,id);
    }

    public List<com.example.demo.redisTest.entity.User> queryAll() {
        return redisJpaDao.findAll();
    }
}
