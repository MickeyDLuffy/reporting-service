package com.redbrokers.reports.service;

import com.redbrokers.reports.dto.Report;

import java.util.List;

public interface DataStoreService {
    void storeDataFromRedis( List<Report> data) ;
    List<Report> getDataFromRedis() ;
}
