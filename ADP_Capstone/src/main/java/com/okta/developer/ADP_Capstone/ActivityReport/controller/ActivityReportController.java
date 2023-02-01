package com.okta.developer.ADP_Capstone.ActivityReport.controller;


import com.okta.developer.ADP_Capstone.ActivityReport.entity.ActivityReport;
import com.okta.developer.ADP_Capstone.ActivityReport.payload.ActivityReport_Request;
import com.okta.developer.ADP_Capstone.ActivityReport.repository.ActivityReportRepository;
import com.okta.developer.ADP_Capstone.ActivityReport.service.ActivityReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;


@CrossOrigin("*")
@RestController
@RequestMapping("capstoneApi/auth/activityreport")
public class ActivityReportController {
    @Autowired
    ActivityReportService activityReportService;
    @Autowired
    ActivityReportRepository activityReportRepository;

    public ActivityReportController(ActivityReportService activityReportService, ActivityReportRepository activityReportRepository) {
        this.activityReportService = activityReportService;
        this.activityReportRepository = activityReportRepository;
    }



    @GetMapping("/getlist")
    public List<ActivityReport> getActivityReport(){
        return this.activityReportRepository.findAll();

    }

    @PostMapping("/post")
    public ActivityReport completeActivityReport(@RequestBody ActivityReport_Request request) throws URISyntaxException {
        ActivityReport savedActivityReport = activityReportService.setActivityReport(request);
        activityReportService.save(savedActivityReport);
        return ResponseEntity.created(
                new URI("/activityreport/" + savedActivityReport.getActivityreportID())).body(savedActivityReport).getBody();
    }
}
