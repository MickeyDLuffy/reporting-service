package com.redbrokers.reports.service.rabbitmq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.Version;

@Service
@Slf4j
public class RabbitMQMessageListener {
    void handleMessage(String message){
        log.info(message);
    }

}
