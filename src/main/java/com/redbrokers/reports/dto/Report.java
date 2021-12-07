package com.redbrokers.reports.dto;

import com.redbrokers.reports.enums.EventType;
import lombok.Data;
import lombok.Value;

@Data
public class Report {
    private int description;
    private EventType eventType;

    @Override
    public String toString() {
        return "Report{" +
                "description=" + description +
                ", eventType=" + eventType +
                '}';
    }
}
