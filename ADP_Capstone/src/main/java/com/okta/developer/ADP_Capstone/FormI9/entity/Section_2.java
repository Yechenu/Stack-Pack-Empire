package com.okta.developer.ADP_Capstone.FormI9.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.sql.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "section_2")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "created_at", "updated_at" }, allowGetters = true)
public class Section_2 {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "Section2_ID", nullable = false)
    private Long section_2ID;

    @Column(name = "EmployeeStartDate", length=60)
    private Date employeeStartDate;

    @Column(name = "EmployerSig", length=60)
    private String employerSig;

    @Column(name = "DateCompleted", length=60)
    private Date dateCompleted;

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
}