package com.redbrokers.reports.restcontroller;


import com.redbrokers.reports.config.RabbitMQConfig;
import com.redbrokers.reports.dto.ReportDTO;
import com.redbrokers.reports.repository.ReportsReceivedRepository;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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

    @PostMapping("/")
    public ResponseEntity<?> publishMessage(@RequestBody String message){
        template.convertAndSend(topicExchange.getName(), RabbitMQConfig.routeKey, message);
        return ResponseEntity.ok("PUBLISHED");
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/new-notification",
            method = RequestMethod.GET,
//            consumes = MediaType.ALL,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public SseEmitter handle(HttpServletResponse response) throws IOException {
        response.setHeader("Access-Control-Allow-Origin", "*");
        SseEmitter emitter = new SseEmitter();
        emitter.send("Mssdsdd");
        return emitter;
    }



}
