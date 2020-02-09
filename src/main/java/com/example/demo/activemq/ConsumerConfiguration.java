package com.example.demo.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;

import javax.jms.ConnectionFactory;

//消息队列消费者配置类
@Configuration
public class ConsumerConfiguration {

    @Value("${spring.activemq.broker-url}")
    private String host;

    @Bean
    public ConnectionFactory getActiveMqConnection(){
        return new ActiveMQConnectionFactory(host);
    }

    @Bean(name="queueListenerContainerFactory")
    public JmsListenerContainerFactory queueListenerContailerFactory(ConnectionFactory connectionFactory){
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setPubSubDomain(false);
        return factory;
    }
    @Bean(name="topicListenerContainerFactory")
    public JmsListenerContainerFactory topicListenerContainerFactory(ConnectionFactory connectionFactory){
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setPubSubDomain(true);
        return factory;
    }
}
