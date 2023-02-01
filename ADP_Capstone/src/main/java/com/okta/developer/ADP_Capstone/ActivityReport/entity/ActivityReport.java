package com.okta.developer.ADP_Capstone.ActivityReport.entity;

import com.okta.developer.ADP_Capstone.FormI9.Form.entity.Form_I9;
import jakarta.persistence.*;
import lombok.*;


@NoArgsConstructor
@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "Activity_Report")
public class ActivityReport {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long activityreportID;
    private String User;
    private String Country;
    private String State;
    private String City;
    private String Reviewer;

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "formid")
    private Form_I9 form_i9;

    public ActivityReport(Long activityreportID, String user, String country, String state, String city, String reviewer) {
        this.activityreportID = activityreportID;
        this.User = user;
        this.Country = country;
        this.State = state;
        this.City = city;
        this.Reviewer = reviewer;
    }
}
