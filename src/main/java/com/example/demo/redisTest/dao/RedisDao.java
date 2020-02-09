package com.example.demo.redisTest.dao;

import com.example.demo.redisTest.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Repository
public class RedisDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;  //这个是系统自带的

    public List<User> queryUser(Integer id) {
        List<User> list = jdbcTemplate.query("select * from user where id = ?",new BeanPropertyRowMapper(User.class),id);
        return list;
    }

    public int queryCount() {
        int count = jdbcTemplate.queryForObject("select count(*) from user",Integer.class);
        return count;
    }

    public List<Map<String,Object>> queryByPage(Integer pageSize,Integer currectPage){
        List<Map<String,Object>> list = jdbcTemplate.queryForList("select * from user order by id limit ?,? ",(currectPage-1)*pageSize, pageSize);
        return list;
    }

    public void insertUser(String name,String passWord){
        StringBuffer sql = new StringBuffer();
        sql.append("insert into user (username,password) values ")
                .append("('" + name + "','" + passWord + "')");
        jdbcTemplate.execute(sql.toString());
    }

    public void deleteUser(Integer id) {
        StringBuffer sql = new StringBuffer();
        sql.append("delete from user where id = ")
                .append(id);
        jdbcTemplate.execute(sql.toString());
    }

    public void editUser(String name,String passWord,Integer id){
        StringBuffer sql = new StringBuffer();
        sql.append("update user set username ")
                .append("= '" + name + "',password='" + passWord + "' where id = "+ id);
        jdbcTemplate.execute(sql.toString());
    }
}
