package com.okta.developer.ADP_Capstone.FormI9.dto;


import lombok.Data;
import java.sql.Timestamp;
import java.util.Date;

@Data
public class Section1DTO {
    private Long section1_ID;
    private Integer employeeID;
    private Integer formID;
    private String lName;
    private String fName;
    private String middle;
    private String other_Name;
    private String address;
    private Integer aptNum;
    private String city;
    private String state;
    private Integer zipCode;
    private Date dob;
    private Integer ssn;
    private String email;
    private Integer telephone;
    private Integer attestationNum;
    private Date expirationDate;
    private Integer uscisNum;
    private Integer formI94_admissionNum;
    private Boolean eSign;
    private Boolean preparerCert;
    private Boolean preparerEsign;
    private String preparerLname;
    private String preparerFname;
    private String preparerAddress;
    private String preparerCity;
    private String preparerState;
    private Integer preparerZip;
    private Timestamp created_At;
    private Timestamp modified_At;

}
