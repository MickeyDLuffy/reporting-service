package com.redbrokers.reports.service.redis;
@FunctionalInterface
public interface MessagePublisher {
    void publish(final String message);
}
