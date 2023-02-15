package com.okta.developer.ADP_Capstone.FormI9.Form.payload;

import com.okta.developer.ADP_Capstone.FormI9.Form.entity.Section1;
import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link Section1} entity
 */

@Data
public class Section1_Request implements Serializable {

    private final String employee_Fname;
    private final String employee_Lname;
    private final String employee_MI;
    private final String employee_Oname;
    private final String employee_Address;
    private final int employee_AptNum;
    private final String employee_City;
    private final String employee_State;
    private final String employee_Zip;
    private final String employee_DOB;
    private final String employee_SSN;
    private final String employee_Email;
    private final String employee_Phone;
    private final String employee_Attestation;
    private final String expirationDate;
    private final int USCISnum;
    private final int formI94_AdmissionNum;
    private final String employee_ESign;
    private final String preparerLname;
    private final String preparerFname;
    private final String preparerAddress;
    private final String preparerCity;
    private final String preparerState;
    private final String preparerZip;
}