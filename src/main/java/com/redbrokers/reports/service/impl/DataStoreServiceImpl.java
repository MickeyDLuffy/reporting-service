package com.redbrokers.reports.service.impl;

import com.redbrokers.reports.dto.Report;
import com.redbrokers.reports.service.DataStoreService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DataStoreServiceImpl implements DataStoreService {
    List<Report> store;

    @Override
    public void storeDataFromRedis(List<Report> data) {
        this.store = data;
    }

    @Override
    public List<Report> getDataFromRedis() {
        return this.store;
    }
}
