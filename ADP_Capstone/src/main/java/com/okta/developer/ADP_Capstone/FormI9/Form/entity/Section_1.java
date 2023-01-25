package com.okta.developer.ADP_Capstone.FormI9.Form.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.sql.Timestamp;
import java.sql.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "section_1")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "created_at", "updated_at" }, allowGetters = true)
public class Section_1 {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Section1_ID", nullable = false, length = 20)
    private Long section1_ID;

    @Column(name = "EmployeeID", length=60, nullable = false)
    private Long employeeID;

    @Column(name = "FormID", length=60,nullable = false)
    private Long formID;

    @Column(name = "Lname", length=60)
    private String lName;

    @Column(name = "Fname", length=60)
    private String fName;

    @Column(name = "Middle", length=60)
    private String middle;

    @Column(name = "Other_name", length=60)
    private String other_Name;

    @Column(name = "Address", length=60)
    private String address;

    @Column(name = "AptNum", length=60)
    private Integer aptNum;

    @Column(name = "City", length=60)
    private String city;

    @Column(name = "State", length=60)
    private String state;

    @Column(name = "ZipCode", length=60)
    private String zipCode;

    @Column(name = "DOB", length=60)
    private Date dob;

    @Column(name = "SSN", length=60)
    private Integer ssn;

    @Column(name = "Email", length=60)
    private String email;

    @Column(name = "Telephone", length=60)
    private String telephone;

    @Column(name = "AttestationNum", length=60)
    private Integer attestationNum;

    @Column(name = "ExpirationDate", length=60)
    private Date expirationDate;

    @Column(name = "USCISnum", length=60)
    private Integer uscisNum;

    @Column(name = "FormI94_AdmissionNum", length=60)
    private Integer formI94_admissionNum;

    @Column(name = "Esign", length=60, nullable = false)
    private Boolean eSign;

    @Column(name = "PreparerCert", length=60)
    private Boolean preparerCert;

    @Column(name = "PreparerEsign", length=60)
    private Boolean preparerEsign;

    @Column(name = "PreparerLname", length=60)
    private String preparerLname;

    @Column(name = "PreparerFname", length=60)
    private String preparerFname;

    @Column(name = "PreparerAddress", length=60)
    private String preparerAddress;

    @Column(name = "PreparerCity", length=60)
    private String preparerCity;

    @Column(name = "PreparerState", length=60)
    private String preparerState;

    @Column(name = "PreparerZip", length=60)
    private String preparerZip;

    @Column(name = "Created_At", length=6)
    private Timestamp created_At;

    @Column(name = "Modified_At", length=6)
    private Timestamp modified_At;


}