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
    private int FormID;
    private String Country;
    private String State;
    private String City;
    private String Reviewer;

    public ActivityReport(Long activityreportID, String user, int formID, String country, String state, String city, String reviewer) {
        this.activityreportID = activityreportID;
        this.User = user;
        this.FormID = formID;
        this.Country = country;
        this.State = state;
        this.City = city;
        this.Reviewer = reviewer;
    }
}
