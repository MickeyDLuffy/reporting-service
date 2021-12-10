package com.redbrokers.reports.repository;

import com.redbrokers.reports.entity.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ReportsReceivedRepository extends JpaRepository<Report, UUID> {
}
