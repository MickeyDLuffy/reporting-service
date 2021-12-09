package com.redbrokers.reports.config;

import com.redbrokers.reports.service.rabbitmq.RabbitMQMessageListener;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
    @Autowired
    RabbitMQMessageListener listener;

    private String exchangeName = "Red-Brokers-ReportingMQ";
    private String queueName = "ReportingMQ";
    public static String routeKey = "routeKey";

    @Bean
    CachingConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory("rattlesnake.rmq.cloudamqp.com");
        connectionFactory.setUsername("rsfzsoxe");
        connectionFactory.setPassword("G6LYnMqokgkvo1uG7rLDtfRWDyf_a2u7");
        connectionFactory.setVirtualHost("rsfzsoxe");

        //Recommended settings
        connectionFactory.setRequestedHeartBeat(30);
        connectionFactory.setConnectionTimeout(30000);

        return connectionFactory;
    }
    @Bean
    TopicExchange exchange() {
        return new TopicExchange(exchangeName, false, false);
    }

    @Bean
    Queue queue() {
        return new Queue(queueName, false, false, false);
    }

    @Bean
    Binding binding() {
        return BindingBuilder.bind(queue()).to(exchange()).with(routeKey);
    }

    @Bean
    RabbitAdmin rabbitAdmin(){
        RabbitAdmin admin = new RabbitAdmin(connectionFactory());
        admin.declareQueue(queue());
        admin.declareExchange(exchange());
        admin.declareBinding(binding());
        return admin;
    }

    @Bean
    SimpleMessageListenerContainer container(){
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory());
        return container;
    }

    @Bean
    RabbitTemplate rabbitTemplate(){
        return new RabbitTemplate(connectionFactory());
    }

    @Bean
    void init(){
        MessageListenerAdapter adapter = new MessageListenerAdapter(listener);
        container().setMessageListener(adapter);
        container().setQueues(queue());
        container().start();

    }
}
