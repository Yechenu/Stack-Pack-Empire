package com.okta.developer.ADP_Capstone.FormI9.Section1.payload;

import com.okta.developer.ADP_Capstone.FormI9.Section1.entity.Section1;
import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

/**
 * A DTO for the {@link Section1} entity
 */

@Data
public class Section1_Request implements Serializable {

    private final String lName;
    private final String fName;
    private final String middle;
    private final String other_Names;
    private final String address;
    private final String aptNum;
    private final String city;
    private final String state;
    private final String zipCode;
    private final Date dob;
    private final Long SSN;
    private final String email;
    private final String phone;
    private final int attestationNum;
    private final Date expirationDate;
    private final int uscisNum;
    private final int formI94_AdmissionNum;
    private final byte[] employee_ESign;
    private final String preparer_lName;
    private final String preparer_fName;
    private final String preparer_Address;
    private final String preparer_City;
    private final String preparer_State;
    private final String preparer_Zip;
}