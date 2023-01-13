package com.model;

public class Document {

    String listType,documentType,issuingAuthority, expirationDate, documentPdf;

    public Document(String listType, String documentType, String issuingAuthority,
                    String expirationDate, String documentPdf) {
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

    public String getDocumentPdf() {
        return documentPdf;
    }

    public void setDocumentPdf(String documentPdf) {
        this.documentPdf = documentPdf;
    }
}
