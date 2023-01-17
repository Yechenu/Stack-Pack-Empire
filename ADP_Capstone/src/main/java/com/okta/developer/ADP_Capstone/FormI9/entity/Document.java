package com.okta.developer.ADP_Capstone.FormI9.entity;

import java.io.InputStream;

public class Document {

    private String listType,documentType,issuingAuthority, expirationDate;
    private InputStream documentPdf;

    public Document(String listType, String documentType, String issuingAuthority,
                    String expirationDate, InputStream documentPdf) {
        this.listType = listType;
        this.documentType = documentType;
        this.issuingAuthority= issuingAuthority;
        this.expirationDate= expirationDate;
        this.documentPdf = documentPdf;
    }

    public String getListType() {
        return listType;
    }

    public void setListType(String listType) {
        this.listType = listType;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getIssuingAuthority() {
        return issuingAuthority;
    }

    public void setIssuingAuthority(String issuingAuthority) {
        this.issuingAuthority = issuingAuthority;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public InputStream getDocumentPdf() {
        return documentPdf;
    }

    public void setDocumentPdf(InputStream documentPdf) {
        this.documentPdf = documentPdf;
    }
}
