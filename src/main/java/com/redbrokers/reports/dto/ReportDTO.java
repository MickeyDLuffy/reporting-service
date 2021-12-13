package com.redbrokers.reports.dto;

import com.redbrokers.reports.enums.EventType;
import lombok.Data;
import lombok.Value;

@Data
public class ReportDTO {
    private String description;
    private EventType eventType;

    public ReportDTO(String description, EventType eventType) {
        this.description = description;
        this.eventType = eventType;
    }


    @Override
    public String toString() {
        return "Report{" +
                "description=" + description +
                ", eventType=" + eventType +
                '}';
    }
}
