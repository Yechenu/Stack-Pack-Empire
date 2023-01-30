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
            savedActivityReport.setActivity(request.getActivity());
            savedActivityReport.setDate(request.getDate());
            savedActivityReport.setDue_Date(request.getDue_Date());

            return savedActivityReport;
    }
    public void save(ActivityReport activityReport) {
        activityReportRepository.save(activityReport);
    }
}
