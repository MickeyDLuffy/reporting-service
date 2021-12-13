package com.redbrokers.reports.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.redbrokers.reports.enums.EventType;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import java.time.OffsetDateTime;
import java.util.UUID;
@Entity
@Data
@NoArgsConstructor
public class Report {
    @Id
    private UUID id;
    private String description;
    @Enumerated(EnumType.STRING)
    private EventType EventType;
    private OffsetDateTime EventTimestamp;

}
