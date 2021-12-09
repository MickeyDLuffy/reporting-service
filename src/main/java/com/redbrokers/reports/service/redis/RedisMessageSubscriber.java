package com.redbrokers.reports.service.redis;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.redbrokers.reports.dto.ReportDTO;
import com.redbrokers.reports.service.DataStoreService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class RedisMessageSubscriber implements MessageListener {
    private final DataStoreService  dataStoreService;
    @Override
    public void onMessage(Message message, byte[] pattern) {
        ObjectMapper objectMapper = new ObjectMapper();
//        dataStoreService.storeDataFromRedis("I am from redis");

        List<ReportDTO> reportDTO = null;
        try {
            TypeReference<List<ReportDTO>> typeRef
                    = new TypeReference<>() {};
            reportDTO = objectMapper.readValue(message.getBody(), typeRef);

        } catch (IOException e) {
            e.printStackTrace();
        }

        log.info("Loggn the data {}", reportDTO);
    }
}
