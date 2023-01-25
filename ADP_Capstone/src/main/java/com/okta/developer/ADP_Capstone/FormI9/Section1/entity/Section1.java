package com.okta.developer.ADP_Capstone.FormI9.Section1.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.sql.Date;

@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "section1_id")
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
public class Section1 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long section1_id;

    private String lName;
    private String fName;
    private String middle;
    private String other_Names;
    private String address;
    private String aptNum;
    private String city;
    private String state;
    private String zipCode;
    private Date dob;
    private Long SSN;
    private String email;
    private String phone;
    private int attestationNum;
    private Date expirationDate;
    private int uscisNum;
    private int formI94_AdmissionNum;
    private byte[] employee_ESign;
    private String preparer_lName;
    private String preparer_fName;
    private String preparer_Address;
    private String preparer_City;
    private String preparer_State;
    private String preparer_Zip;
    private Date created_At;
    private Date modified_At;
}
