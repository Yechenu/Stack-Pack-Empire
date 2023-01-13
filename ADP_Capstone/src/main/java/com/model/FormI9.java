package com.model;

public class FormI9 {
    int employeeID, formID, zipCode;
    String lName, fName, midName, citizenshipStatus, documentType,
    employerTitle,employer_Fname, employerOrg, orgAddress, city,state;

    public FormI9(int employeeID, int formID, int zipCode, String lName, String fName,
                  String midName, String citizenshipStatus, String documentType,
                  String employerTitle, String employer_Fname, String employerOrg,
                  String orgAddress, String city, String state) {
        this.employeeID = employeeID;
        this.formID = formID;
        this.zipCode = zipCode;
        this.lName = lName;
        this.fName = fName;
        this.midName = midName;
        this.citizenshipStatus = citizenshipStatus;
        this.documentType = documentType;
        this.employerTitle = employerTitle;
        this.employer_Fname = employer_Fname;
        this.employerOrg = employerOrg;
        this.orgAddress = orgAddress;
        this.city = city;
        this.state = state;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public int getFormID() {
        return formID;
    }

    public void setFormID(int formID) {
        this.formID = formID;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getMidName() {
        return midName;
    }

    public void setMidName(String midName) {
        this.midName = midName;
    }

    public String getCitizenshipStatus() {
        return citizenshipStatus;
    }

    public void setCitizenshipStatus(String citizenshipStatus) {
        this.citizenshipStatus = citizenshipStatus;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getEmployerTitle() {
        return employerTitle;
    }

    public void setEmployerTitle(String employerTitle) {
        this.employerTitle = employerTitle;
    }

    public String getEmployer_Fname() {
        return employer_Fname;
    }

    public void setEmployer_Fname(String employer_Fname) {
        this.employer_Fname = employer_Fname;
    }

    public String getEmployerOrg() {
        return employerOrg;
    }

    public void setEmployerOrg(String employerOrg) {
        this.employerOrg = employerOrg;
    }

    public String getOrgAddress() {
        return orgAddress;
    }

    public void setOrgAddress(String orgAddress) {
        this.orgAddress = orgAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
