package com.redbrokers.reports.entity;

import com.redbrokers.reports.enums.EventType;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;
@Entity
@Data
@NoArgsConstructor
public class Report {
    @Id
    private UUID id;
    private String description;
    private EventType EventType;

}
