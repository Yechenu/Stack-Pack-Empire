package com.okta.developer.ADP_Capstone.ActivityReport.payload;

import lombok.Data;

import java.io.Serializable;


@Data
public class ActivityReport_Request implements Serializable {

    public final Long activityreportID;
    public final String Lname;
    public final String Fname;
    public final String Country;
    public final String State;
    public final String City;
    public final String Reviewer;
}