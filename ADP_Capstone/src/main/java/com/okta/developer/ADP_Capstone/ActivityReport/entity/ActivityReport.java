package com.okta.developer.ADP_Capstone.ActivityReport.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Builder
@NoArgsConstructor
@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "Activity_Report")
public class ActivityReport {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long activityreportID;
    private String User;
    private String Activity;
    private Date Date;
    private Date Due_Date;

    public ActivityReport(Long activityreportID, String user, String activity, Date date, Date due_Date) {
        this.activityreportID = activityreportID;
        User = user;
        Activity = activity;
        Date = date;
        Due_Date = due_Date;
    }
}