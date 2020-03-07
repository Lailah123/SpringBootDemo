package com.example.demo.redisTest.controller;

import com.example.demo.redisTest.bean.User;
import com.example.demo.redisTest.service.RedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/v1/redis")
public class RedisController {
    private static Logger log = LoggerFactory.getLogger(RedisController.class);
    final
    RedisService redisService;

    public RedisController(RedisService redisService) {
        this.redisService = redisService;
    }

    @RequestMapping(value = "/queryUser",method= RequestMethod.POST)
    public List<User> queryUser(@RequestBody Map<String,Integer> parame) {
        List<User> users = redisService.queryUser(parame.get("id"));
        return users;
    }

    @RequestMapping(value = "/queryCount")
    public int queryCount(){
        int count = redisService.queryCount();
        return count;
    }

    @RequestMapping(value = "/queryByPage")
    public List<Map<String,Object>> queryByPage(@RequestBody Map<String,Integer> parame) {
        List<Map<String, Object>> list = redisService.queryByPage(parame.get("pageSize"), parame.get("currectPage"));
        return list;
    }

    @RequestMapping(value = "/insertUser")
    public void insertUser(@RequestBody Map<String,Object> parame) {
        redisService.insertUser((String) parame.get("name"),(String) parame.get("passWord"));
    }

    @RequestMapping(value = "/deleteUser")
    public void deleteUser(@RequestBody Map<String, Integer> parame) {
        redisService.deleteUser(parame.get("id"));
    }

    @RequestMapping(value = "/editUser")
    public void editUser(@RequestBody Map<String, Object> parame) {
        redisService.editUser((String)parame.get("name"),(String)parame.get("passWord"),(Integer) parame.get("id"));
    }

//    @Scheduled(cron = "*/5 * * * * ?")
//    public void execute() {
//        log.info("我在controller里面执行");
//    }

}
