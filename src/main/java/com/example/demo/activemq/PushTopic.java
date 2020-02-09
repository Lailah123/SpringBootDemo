package com.example.demo.activemq;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.jms.Destination;
import java.util.Map;

@Component
public class PushTopic {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;
    @Autowired
    @Qualifier(value="topic")
    private Destination topic;

    @Resource(name="queue")
    private Destination queue;
//    @Scheduled(cron = "*/5 * * * * ?")
//    public void execute() {
//        System.out.println("topic消息队列插入消息");
//        jmsMessagingTemplate.convertAndSend(topic,"topic的消息内容");
//        System.out.println("queue消息队列插入消息");
//        jmsMessagingTemplate.convertAndSend(queue,"queue的消息内容");
//    }
}
