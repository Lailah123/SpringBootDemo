package com.example.demo;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.jms.Destination;

@SpringBootApplication
//开启缓存
@EnableCaching
@EnableScheduling // 开启定时任务功能
//@ComponentScan
public class DemoApplication {
    private static Logger log = LoggerFactory.getLogger(DemoApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        log.info("定时任务开启");
    }

    //activemq消息类型
    @Bean(name="queue")
    public Destination getQueue(){
        return new ActiveMQQueue("queue_test");
    }

    @Bean(name="topic")
    public Destination getTopic(){
        return new ActiveMQTopic("topic_test");
    }

}
