package com.redbrokers.reports.service.impl;

import com.redbrokers.reports.dto.ReportDTO;
import com.redbrokers.reports.service.DataStoreService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataStoreServiceImpl implements DataStoreService {
    List<ReportDTO> store;

    @Override
    public void storeDataFromRedis(List<ReportDTO> data) {
        this.store = data;
    }

    @Override
    public List<ReportDTO> getDataFromRedis() {
        return this.store;
    }
}
