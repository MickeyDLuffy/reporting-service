package com.redbrokers.reports.service.redis;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RedisMessagePublisher implements MessagePublisher {
    private final   RedisTemplate<String, Object> redisTemplate;
    private final ChannelTopic topic;

    @Override
    public void publish(String message) {
        redisTemplate.convertAndSend(topic.getTopic(), message);
    }

}
