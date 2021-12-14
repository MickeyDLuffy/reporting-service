package com.redbrokers.reports.service.rabbitmq;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.redbrokers.reports.dto.ReportDTO;
import com.redbrokers.reports.entity.Report;
import com.redbrokers.reports.enums.EventType;
import com.redbrokers.reports.repository.ReportsReceivedRepository;
import com.redbrokers.reports.restcontroller.ReportRestController;
import com.redbrokers.reports.service.impl.EmitterServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import javax.persistence.Version;
import java.io.IOException;
import java.time.OffsetDateTime;
import java.util.UUID;

@Service
@Slf4j
public class RabbitMQMessageListener {

    @Autowired
    ReportsReceivedRepository reportsReceivedRepository;

    @Autowired
    private EmitterServiceImpl emitterService;

    @Autowired
    ObjectMapper mapper;


    public Report report;


    // Receive queue message and save to DB
    void handleMessage(String message) {
        log.info(message);
        try {
            report = mapper.readValue(message, Report.class);
            report.setId(UUID.randomUUID());
            report.setEventTimestamp(OffsetDateTime.now());
            log.info("{} login reports", report);
            reportsReceivedRepository.save(report);
            emitterService.initPublishEvent(report);
        }catch (IOException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad data format. Please check the format.");
        }
    }

}
