package com.redbrokers.reports.service.rabbitmq;

import com.redbrokers.reports.entity.Report;
import com.redbrokers.reports.enums.EventType;
import com.redbrokers.reports.repository.ReportsReceivedRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Version;
import java.util.UUID;

@Service
@Slf4j
public class RabbitMQMessageListener {
    @Autowired
    ReportsReceivedRepository reportsReceivedRepository;


    // Receive queue message and save to DB
    void handleMessage(String message){
        log.info(message);
        // create a report,
        // or we use object mapper to map the message string to Report class
        Report report = new Report();
        report.setId(UUID.randomUUID());
        report.setDescription(message);
        report.setEventType(EventType.ORDER_CREATED);

        reportsReceivedRepository.save(report);
    }

}
