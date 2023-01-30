package com.okta.developer.ADP_Capstone.FormI9.Section2.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

/**
 * A DTO for the {@link com.okta.developer.ADP_Capstone.FormI9.Section2.entity.Section2} entity
 */
@AllArgsConstructor
@Getter
public class Section2_Request implements Serializable {
    private final String employeeStartDate;
    private final String employerSignature;
    private final String dateCompleted;
    private final String employerTitle;
    private final String employer_Lname;
    private final String employer_Fname;
    private final String employer_BusinessName;
    private final String employer_BusinessAddress;
    private final String employerCity;
    private final String employerState;
    private final String employerZip;
}