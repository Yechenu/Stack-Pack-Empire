package com.okta.developer.ADP_Capstone.FormI9.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.util.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "Document")
@Table(name = "i9_documents")
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="documentID", nullable=false)
    private Integer documentID;

    @Column(name = "documentName", length=60)
    private String documentName;

    @Column(name = "formID", length=60)
    private Integer formID;

    @Column(name = "EmployeeID", length=60)
    private Integer employeeID;

    @Column(name = "ListType", length=60)
    private String listType;

    @Column(name = "IssuingAuthority", length=60)
    private String issuingAuthority;

    @Column(name = "DocumentNumber", length=60)
    private Integer documentNumber;

    @Column(name = "ExpirationDate", length=60)
    private Date expirationDate;

    @Column(name = "AdditionalInfo", length=60)
    private String additionalInfo;

    @Column(name= "fileName")
    private String fileName;

    @Column (name= "fileType")
    private String fileType;

    @Lob
    @Column(name = "filePDF", length=60)
    private byte[] filePDF;

    @Column(name = "created_At", length=60)
    private Timestamp created_At;

    @Column(name = "Modified_At", length=60)
    private Timestamp modified_At;
}



