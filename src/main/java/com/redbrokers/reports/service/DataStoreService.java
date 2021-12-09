package com.redbrokers.reports.service;

import com.redbrokers.reports.dto.ReportDTO;

import java.util.List;

public interface DataStoreService {
    void storeDataFromRedis( List<ReportDTO> data) ;
    List<ReportDTO> getDataFromRedis() ;
}
