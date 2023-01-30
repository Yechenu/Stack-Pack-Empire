package com.okta.developer.ADP_Capstone.Applicant.payload;


import lombok.Data;
import java.io.Serializable;
import java.util.Date;

@Data
public class Applicant_Request implements Serializable {

    public final Long applicantID;
    public final String applicant_Fname;
    public final String applicant_Lname;
    public final int formID;
    public final String eVerifyStatus;
    public final Date applicant_StartDate;
    public final String applicant_City;
    public final String applicant_State;
    public final String applicant_Country;
    public final int employeeID;

}
