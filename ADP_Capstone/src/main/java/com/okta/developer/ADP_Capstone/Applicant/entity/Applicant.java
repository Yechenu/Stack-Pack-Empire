package com.okta.developer.ADP_Capstone.Applicant.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
@Getter
@Setter
@Table(name = "applicant")
@Entity
public class Applicant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    private Long applicantID;
    private String applicant_Fname;
    private String applicant_Lname;
    private int formID;
    private String eVerifyStatus;
    private Date applicant_StartDate;
    private String applicant_City;
    private String applicant_State;
    private String applicant_Country;
    private int employeeID;

    public Applicant(Long applicantID, String applicant_Fname, String applicant_Lname, int formID, String eVerifyStatus,
                     Date applicant_StartDate, String applicant_City, String applicant_State, String applicant_Country, int employeeID) {
        this.applicantID = applicantID;
        this.applicant_Fname = applicant_Fname;
        this.applicant_Lname = applicant_Lname;
        this.formID = formID;
        this.eVerifyStatus = eVerifyStatus;
        this.applicant_StartDate = applicant_StartDate;
        this.applicant_City = applicant_City;
        this.applicant_State = applicant_State;
        this.applicant_Country = applicant_Country;
        this.employeeID = employeeID;
    }
}
