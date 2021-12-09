package com.redbrokers.reports.service.rabbitmq;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.redbrokers.reports.config.RabbitMQConfig;
import com.redbrokers.reports.dto.ReportDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RabbitMQMessagePublisher {
    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    TopicExchange topicExchange;

    void publish(ReportDTO reportDTO) throws JsonProcessingException {
        rabbitTemplate.convertAndSend(topicExchange.getName(), RabbitMQConfig.routeKey, new ObjectMapper().writeValueAsString(reportDTO));
        log.info(String.valueOf(reportDTO));

    }

}
