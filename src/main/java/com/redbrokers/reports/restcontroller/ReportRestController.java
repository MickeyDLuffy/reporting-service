package com.redbrokers.reports.restcontroller;


import com.redbrokers.reports.config.RabbitMQConfig;
import com.redbrokers.reports.repository.ReportsReceivedRepository;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mq")
public class ReportRestController {


    @Autowired
    RabbitTemplate template;

    @Autowired
    TopicExchange topicExchange;

    @Autowired
    RabbitMQConfig rabbitMQConfig;

    @Autowired
    ReportsReceivedRepository reportsReceivedRepository;

    @PutMapping("/{message}")
    public ResponseEntity publishMessage(@PathVariable String message){
        template.convertAndSend(topicExchange.getName(), RabbitMQConfig.routeKey, message);
        return ResponseEntity.ok("PUBLISHED");
    }
    
}
