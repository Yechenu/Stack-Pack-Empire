package com.okta.developer.ADP_Capstone.FormI9.Section1.payload;

import com.okta.developer.ADP_Capstone.FormI9.Section1.entity.Section1;
import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link Section1} entity
 */

@Data
public class Section1_Request implements Serializable {

    private final String lastName;
    private final String firstName;
    private final String middleName;
    private final String otherNames;
    private final String address;
    private final int aptNum;
    private final String city;
    private final String state;
    private final String zipCode;
    private final String dob;
    private final String ssn;
    private final String email;
    private final String phone;
    private final int attestationNum;
    private final String expirationDate;
    private final int uscisNum;
    private final int formI94_AdmissionNum;
    private final String employee_ESign;
    private final String preparer_lName;
    private final String preparer_fName;
    private final String preparer_Address;
    private final String preparer_City;
    private final String preparer_State;
    private final String preparer_Zip;
}