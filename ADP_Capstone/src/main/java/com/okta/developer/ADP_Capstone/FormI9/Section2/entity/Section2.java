package com.okta.developer.ADP_Capstone.FormI9.Section2.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "section2")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "created_at", "updated_at" }, allowGetters = true)
public class Section2 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "Section2_ID", nullable = false)
    private Long section2_ID;

    @Column(name = "EmployeeStartDate", length=60)
    private String employeeStartDate;

    @Column(name = "EmployerSig", length=60)
    private String employerSignature;

    @Column(name = "DateCompleted", length=60)
    private String dateCompleted;

    @Column(name = "EmployerTitle", length=60)
    private String employerTitle;

    @Column(name = "Employer_Lname", length=60)
    private String employer_Lname;

    @Column(name = "Employer_Fname", length=60)
    private String employer_Fname;

    @Column(name = "Employer_BusinessName", length=60)
    private String employer_BusinessName;

    @Column(name = "Employer_BusinessAddress", length=60)
    private String employer_BusinessAddress;

    @Column(name = "EmployerCity", length=60)
    private String employerCity;

    @Column(name = "EmployerState", length=60)
    private String employerState;

    @Column(name = "EmployerZip", length=60)
    private String employerZip;
    @CreatedDate
    private Date created_At;
    @LastModifiedDate
    private Date modified_At;

    public Section2(String employeeStartDate, String employerSignature, String dateCompleted,
                    String employerTitle, String employer_Lname, String employer_Fname,
                    String employer_BusinessName, String employer_BusinessAddress, String employerCity,
                    String employerState, String employerZip) {
        this.employeeStartDate = employeeStartDate;
        this.employerSignature = employerSignature;
        this.dateCompleted = dateCompleted;
        this.employerTitle = employerTitle;
        this.employer_Lname = employer_Lname;
        this.employer_Fname = employer_Fname;
        this.employer_BusinessName = employer_BusinessName;
        this.employer_BusinessAddress = employer_BusinessAddress;
        this.employerCity = employerCity;
        this.employerState = employerState;
        this.employerZip = employerZip;
    }
}