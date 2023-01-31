package com.okta.developer.ADP_Capstone.ActivityReport.payload;

import lombok.Data;

import java.io.Serializable;
import java.util.*;

@Data
public class ActivityReport_Request implements Serializable {

    public final Long activityreportID;
    public final String User;
    public final int FormID;
    public final String Country;
    public final String State;
    public final String City;
    public final String Reviewer;
}