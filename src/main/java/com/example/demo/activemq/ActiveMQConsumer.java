package com.example.demo.activemq;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

//消息队列消费者
@Component
public class ActiveMQConsumer {
    //接收queue消息
    @JmsListener(destination = "queue_test",containerFactory =
            "queueListenerContainerFactory")
    public void handler(String message){
        System.out.println(message);
    }
    //接收topic消息
    @JmsListener(destination = "topic_test",containerFactory =
            "topicListenerContainerFactory")
    public void handlerTopic(String msessage){
        System.out.println(msessage);
    }
}
