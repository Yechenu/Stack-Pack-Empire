package com.okta.developer.ADP_Capstone.ActivityReport.repository;

import com.okta.developer.ADP_Capstone.ActivityReport.entity.ActivityReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityReportRepository extends JpaRepository<ActivityReport, Long> {
}
