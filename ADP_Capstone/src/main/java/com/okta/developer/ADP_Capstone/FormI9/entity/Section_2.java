package com.okta.developer.ADP_Capstone.FormI9.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.sql.Date;
import java.sql.Timestamp;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
@Entity(name = "Section_2")
@Table(name = "section_2")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "created_at", "updated_at" }, allowGetters = true)
public class Section_2 {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "Section2_ID", nullable = false)
    private Integer section_2ID;

    @Column(name = "EmployeeStartDate", length=60)
    private Timestamp employeeStartDate;

    @Column(name = "EmployerSig", length=60)
    private String employerSig;

    @Column(name = "Date", length=60)
    private Date date;

    @Column(name = "EmployerTitle", length=60)
    private String employerTitle;

    @Column(name = "Employer_Lname", length=60)
    private String employer_Lname;

    @Column(name = "Employer_Fname", length=60)
    private String employer_Fname;

    @Column(name = "E_BusinessName", length=60)
    private String e_BusinessName;

    @Column(name = "E_BusinessAddress", length=60)
    private String e_BusinessAddress;

    @Column(name = "EmployerCity", length=60)
    private String employerCity;

    @Column(name = "EmployerState", length=60)
    private String employerState;

    @Column(name = "EmployerZip", length=60)
    private Integer employerZip;
}