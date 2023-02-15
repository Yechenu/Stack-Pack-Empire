package com.okta.developer.ADP_Capstone.FormI9.Form.payload;

import com.okta.developer.ADP_Capstone.FormI9.Form.entity.Section2;
//import lombok.AllArgsConstructor;
import lombok.Data;
//import lombok.Getter;

import java.io.Serializable;
import java.sql.Date;

/**
 * A DTO for the {@link Section2} entity
 */
@Data
public class Section2_Request implements Serializable {
    private  String employee_Fname;
    private  String employee_Lname;
    private  String employee_MI;
    private  String employee_Citizenship;


    private  String listCategory1;
    private  String documentTitle1;
    private  String issuingAuthority1;
    private  Long documentNum1;
    private  Date expirationDate1;

    private  String listCategory2;
    private  String documentTitle2;
    private  String issuingAuthority2;
    private  Long documentNum2;
    private  Date expirationDate2;

    private  String additional_Inf;

    private  String employee_StartDate;
    private  String employerTitle;
    private  String employer_Lname;
    private  String employer_Fname;
    private  String employer_BusinessName;
    private  String employer_BusinessAddress;
    private  String employer_BusinessCity;
    private  String employer_BusinessState;
    private  String employer_BusinessZip;
    private  String employer_Signature;
    private  String dateCompleted;

   public Section2_Request() { }

}