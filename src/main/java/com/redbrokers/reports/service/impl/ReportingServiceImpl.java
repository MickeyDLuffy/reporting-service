package com.redbrokers.reports.service.impl;

import com.redbrokers.reports.dto.Report;
import com.redbrokers.reports.service.DataStoreService;
import com.redbrokers.reports.service.ReportingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;

public class ReportingServiceImpl implements ReportingService {
    @Autowired
    private DataStoreService dataStoreService;

    @Override
    public ResponseEntity<?> getDataFromRedisQueue(Report report) {
        return new ResponseEntity<>(dataStoreService.getDataFromRedis(), HttpStatus.ACCEPTED);
    }

    @Override
    public ResponseEntity<?> processReport(Report report) {
        //send report to db
        return null;
    }
}



