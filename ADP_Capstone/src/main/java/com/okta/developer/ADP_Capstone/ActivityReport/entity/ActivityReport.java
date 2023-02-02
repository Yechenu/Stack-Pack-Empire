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
    private String Lname;
    private String Fname;
    private String Country;
    private String State;
    private String City;
    private String Reviewer;

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "formid")
    private Form_I9 form_i9;

    public ActivityReport(Long activityreportID, String lname, String fname, String country, String state, String city, String reviewer, Form_I9 form_i9) {
        this.activityreportID = activityreportID;
        Lname = lname;
        Fname = fname;
        Country = country;
        State = state;
        City = city;
        Reviewer = reviewer;
        this.form_i9 = form_i9;
    }
}

