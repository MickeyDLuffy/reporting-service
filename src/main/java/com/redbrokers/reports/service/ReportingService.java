package com.redbrokers.reports.service;

import com.redbrokers.reports.dto.ReportDTO;
import org.springframework.http.ResponseEntity;

public interface ReportingService {
    ResponseEntity<?> getDataFromRedisQueue(ReportDTO reportDTO);

    ResponseEntity<?> processReport(ReportDTO reportDTO);
}
