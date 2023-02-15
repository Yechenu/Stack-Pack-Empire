package com.okta.developer.ADP_Capstone.FormI9.Form.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import jakarta.persistence.*;
import com.okta.developer.ADP_Capstone.Personell.entity.Applicant;
import lombok.*;
//import org.springframework.data.annotation.CreatedDate;
//import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.sql.Date;
//import java.util.*;

//@AllArgsConstructor
//@NoArgsConstructor
//@Getter
//@Setter

@Entity
@Table(name = "section2")
@EntityListeners(AuditingEntityListener.class)
public class Section2 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    private Long section2_ID;
    @OneToOne
    @JoinColumn(name = "applicant_id_applicant_id")
    private Applicant applicantID;
    private String employee_Fname;
    private String employee_Lname;
    private String employee_MI;
    private String employee_Citizenship;


    private String listCategory1;
    private String documentTitle1;
    private String issuingAuthority1;
    private Long documentNum1;
    private Date expirationDate1;

    private String listCategory2;
    private String documentTitle2;
    private String issuingAuthority2;
    private Long documentNum2;
    private Date expirationDate2;

    private String additional_Inf;
    private String employee_StartDate;


    private String employerTitle;


    private String employer_Lname;


    private String employer_Fname;


    private String employer_BusinessName;


    private String employer_BusinessAddress;


    private String employer_BusinessCity;


    private String employer_BusinessState;


    private String employer_BusinessZip;
    private String employer_Signature;


    private String dateCompleted;

    public Applicant getApplicantID() {
        return applicantID;
    }

    public void setApplicantID(Applicant applicantID) {
        this.applicantID = applicantID;
    }

//    @CreatedDate
//    private Date created_At;
//    @LastModifiedDate
//    private Date modified_At;

    public Section2() {
//
    }

    public Long getSection2_ID() {
        return section2_ID;
    }

    public void setSection2_ID(Long section2_ID) {
        this.section2_ID = section2_ID;
    }

    public String getEmployee_Fname() {
        return employee_Fname;
    }

    public void setEmployee_Fname(String employee_Fname) {
        this.employee_Fname = employee_Fname;
    }

    public String getEmployee_Lname() {
        return employee_Lname;
    }

    public void setEmployee_Lname(String employee_Lname) {
        this.employee_Lname = employee_Lname;
    }

    public String getEmployee_MI() {
        return employee_MI;
    }

    public void setEmployee_MI(String employee_MI) {
        this.employee_MI = employee_MI;
    }

    public String getEmployee_Citizenship() {
        return employee_Citizenship;
    }

    public void setEmployee_Citizenship(String employee_Citizenship) {
        this.employee_Citizenship = employee_Citizenship;
    }

    public String getListCategory1() {
        return listCategory1;
    }

    public void setListCategory1(String listCategory1) {
        this.listCategory1 = listCategory1;
    }

    public String getDocumentTitle1() {
        return documentTitle1;
    }

    public void setDocumentTitle1(String documentTitle1) {
        this.documentTitle1 = documentTitle1;
    }

    public String getIssuingAuthority1() {
        return issuingAuthority1;
    }

    public void setIssuingAuthority1(String issuingAuthority1) {
        this.issuingAuthority1 = issuingAuthority1;
    }

    public Long getDocumentNum1() {
        return documentNum1;
    }

    public void setDocumentNum1(Long documentNum1) {
        this.documentNum1 = documentNum1;
    }

    public Date getExpirationDate1() {
        return expirationDate1;
    }

    public void setExpirationDate1(Date expirationDate1) {
        this.expirationDate1 = expirationDate1;
    }

    public String getListCategory2() {
        return listCategory2;
    }

    public void setListCategory2(String listCategory2) {
        this.listCategory2 = listCategory2;
    }

    public String getDocumentTitle2() {
        return documentTitle2;
    }

    public void setDocumentTitle2(String documentTitle2) {
        this.documentTitle2 = documentTitle2;
    }

    public String getIssuingAuthority2() {
        return issuingAuthority2;
    }

    public void setIssuingAuthority2(String issuingAuthority2) {
        this.issuingAuthority2 = issuingAuthority2;
    }

    public Long getDocumentNum2() {
        return documentNum2;
    }

    public void setDocumentNum2(Long documentNum2) {
        this.documentNum2 = documentNum2;
    }

    public Date getExpirationDate2() {
        return expirationDate2;
    }

    public void setExpirationDate2(Date expirationDate2) {
        this.expirationDate2 = expirationDate2;
    }

    public String getAdditional_Inf() {
        return additional_Inf;
    }

    public void setAdditional_Inf(String additional_Inf) {
        this.additional_Inf = additional_Inf;
    }

    public String getEmployee_StartDate() {
        return employee_StartDate;
    }

    public void setEmployee_StartDate(String employee_StartDate) {
        this.employee_StartDate = employee_StartDate;
    }

    public String getEmployerTitle() {
        return employerTitle;
    }

    public void setEmployerTitle(String employerTitle) {
        this.employerTitle = employerTitle;
    }

    public String getEmployer_Lname() {
        return employer_Lname;
    }

    public void setEmployer_Lname(String employer_Lname) {
        this.employer_Lname = employer_Lname;
    }

    public String getEmployer_Fname() {
        return employer_Fname;
    }

    public void setEmployer_Fname(String employer_Fname) {
        this.employer_Fname = employer_Fname;
    }

    public String getEmployer_BusinessName() {
        return employer_BusinessName;
    }

    public void setEmployer_BusinessName(String employer_BusinessName) {
        this.employer_BusinessName = employer_BusinessName;
    }

    public String getEmployer_BusinessAddress() {
        return employer_BusinessAddress;
    }

    public void setEmployer_BusinessAddress(String employer_BusinessAddress) {
        this.employer_BusinessAddress = employer_BusinessAddress;
    }

    public String getEmployer_BusinessCity() {
        return employer_BusinessCity;
    }

    public void setEmployer_BusinessCity(String employer_BusinessCity) {
        this.employer_BusinessCity = employer_BusinessCity;
    }

    public String getEmployer_BusinessState() {
        return employer_BusinessState;
    }

    public void setEmployer_BusinessState(String employer_BusinessState) {
        this.employer_BusinessState = employer_BusinessState;
    }

    public String getEmployer_BusinessZip() {
        return employer_BusinessZip;
    }

    public void setEmployer_BusinessZip(String employer_BusinessZip) {
        this.employer_BusinessZip = employer_BusinessZip;
    }

    public String getEmployer_Signature() {
        return employer_Signature;
    }

    public void setEmployer_Signature(String employer_Signature) {
        this.employer_Signature = employer_Signature;
    }

    public String getDateCompleted() {
        return dateCompleted;
    }

    public void setDateCompleted(String dateCompleted) {
        this.dateCompleted = dateCompleted;
    }
}
//    public Section2(String employeeStartDate, String employerSignature, String dateCompleted,
//                    String employerTitle, String employer_Lname, String employer_Fname,
//                    String employer_BusinessName, String employer_BusinessAddress, String employer_BusinessCity,
//                    String employer_BusinessState, String employer_BusinessZip) {
//        this.employee_StartDate = employeeStartDate;
//        this.employer_Signature = employerSignature;
//        this.dateCompleted = dateCompleted;
//        this.employerTitle = employerTitle;
//        this.employer_Lname = employer_Lname;
//        this.employer_Fname = employer_Fname;
//        this.employer_BusinessName = employer_BusinessName;
//        this.employer_BusinessAddress = employer_BusinessAddress;
//        this.employer_BusinessCity = employer_BusinessCity;
//        this.employer_BusinessState = employer_BusinessState;
//        this.employer_BusinessZip = employer_BusinessZip;
//    }


