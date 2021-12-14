package com.redbrokers.reports.restcontroller;

import com.redbrokers.reports.service.impl.EmitterServiceImpl;
import com.redbrokers.reports.service.rabbitmq.RabbitMQMessageListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(value = "http://localhost:5500", maxAge = Long.MAX_VALUE)
@RequestMapping(value = "mq/", consumes = MediaType.ALL_VALUE)
public class EmitterRestController {

    @Autowired
    private EmitterServiceImpl emitterService;

    @GetMapping("new-notification")
    public SseEmitter subscribeToSSE() {
        return emitterService.getSSEInstance();
    }

}


