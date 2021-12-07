package com.redbrokers.reports.service;

import com.redbrokers.reports.dto.Report;
import org.springframework.http.ResponseEntity;

public interface ReportingService {
    ResponseEntity<?> getDataFromRedisQueue(Report report);

    ResponseEntity<?> processReport(Report report);
}
