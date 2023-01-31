package com.okta.developer.ADP_Capstone.FormI9.Section2.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.okta.developer.ADP_Capstone.FormI9.Form.entity.Form_I9;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.*;


@NoArgsConstructor
@Setter
@Getter
@ToString(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "section2")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "created_at", "updated_at" }, allowGetters = true)
public class Section_2 {

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
    @CreationTimestamp
    private Date created_At;
    @CreationTimestamp
    private Date modified_At;

   
 @ManyToMany(mappedBy = "section_2s", fetch = FetchType.LAZY)
    private Set<Form_I9> form_i9s = new HashSet<>();


    public Section_2(String employeeStartDate, String employerSignature, String dateCompleted,
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