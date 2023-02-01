package com.okta.developer.ADP_Capstone.ActivityReport.service;


import com.okta.developer.ADP_Capstone.ActivityReport.entity.ActivityReport;
import com.okta.developer.ADP_Capstone.ActivityReport.payload.ActivityReport_Request;
import com.okta.developer.ADP_Capstone.ActivityReport.repository.ActivityReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActivityReportService {

    @Autowired
    ActivityReportRepository activityReportRepository;

    public ActivityReportService(ActivityReportRepository activityReportRepository) {
        this.activityReportRepository = activityReportRepository;
    }

    public ActivityReport setActivityReport(ActivityReport_Request request) {
        ActivityReport savedActivityReport = new ActivityReport();
            savedActivityReport.setActivityreportID(request.getActivityreportID());
            savedActivityReport.setUser(request.getUser());
            savedActivityReport.setCountry(request.getCountry());
            savedActivityReport.setState(request.getState());
            savedActivityReport.setCity(request.getCity());
            savedActivityReport.setReviewer(request.getReviewer());

            return savedActivityReport;
    }
    public void save(ActivityReport activityReport) {
        activityReportRepository.save(activityReport);
    }
}
