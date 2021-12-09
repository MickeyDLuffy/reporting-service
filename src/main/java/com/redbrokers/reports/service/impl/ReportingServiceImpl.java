package com.redbrokers.reports.service.impl;

import com.redbrokers.reports.dto.ReportDTO;
import com.redbrokers.reports.service.DataStoreService;
import com.redbrokers.reports.service.ReportingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ReportingServiceImpl implements ReportingService {
    @Autowired
    private DataStoreService dataStoreService;

    @Override
    public ResponseEntity<?> getDataFromRedisQueue(ReportDTO reportDTO) {
        return new ResponseEntity<>(dataStoreService.getDataFromRedis(), HttpStatus.ACCEPTED);
    }

    @Override
    public ResponseEntity<?> processReport(ReportDTO reportDTO) {
        //send report to db
        return null;
    }
}



