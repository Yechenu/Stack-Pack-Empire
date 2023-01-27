package com.okta.developer.ADP_Capstone.FormI9.Section1.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.*;

@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "section1")
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
public class Section1 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long section1_id;
    private String lastName;
    private String firstName;
    private String middleName;
    private String otherNames;
    private String address;
    private int aptNum;
    private String city;
    private String state;
    private String zipCode;

    private String dob;
   private String ssn;
    private String email;
    private String phone;
    private int attestationNum;
    private String expirationDate;
    private int uscisNum;
    private int formI94_AdmissionNum;
    private String employee_ESign;
    private String preparer_lName;
    private String preparer_fName;
    private String preparer_Address;
    private String preparer_City;
    private String preparer_State;
    private String preparer_Zip;
    @CreatedDate
    private Date created_At;
    @LastModifiedDate
    private Date modified_At;

    public Section1(String lastName, String firstName,
                    String middleName, String otherNames,
                    String address, int aptNum, String city,
                    String state, String zipCode, String dob,
                    String ssn, String email, String phone,
                    int attestationNum, String expirationDate,
                    int uscisNum, int formI94_AdmissionNum,
                    String employee_ESign, String preparer_lName,
                    String preparer_fName, String preparer_Address,
                    String preparer_City, String preparer_State,
                    String preparer_Zip) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.otherNames = otherNames;
        this.address = address;
        this.aptNum = aptNum;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.dob = dob;
        this.ssn = ssn;
        this.email = email;
        this.phone = phone;
        this.attestationNum = attestationNum;
        this.expirationDate = expirationDate;
        this.uscisNum = uscisNum;
        this.formI94_AdmissionNum = formI94_AdmissionNum;
        this.employee_ESign = employee_ESign;
        this.preparer_lName = preparer_lName;
        this.preparer_fName = preparer_fName;
        this.preparer_Address = preparer_Address;
        this.preparer_City = preparer_City;
        this.preparer_State = preparer_State;
        this.preparer_Zip = preparer_Zip;
    }

    public String setSsn(String ssn){
        return this.ssn=ssn;
    }
}
