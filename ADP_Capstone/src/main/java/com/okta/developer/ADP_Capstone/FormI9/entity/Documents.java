package com.okta.developer.ADP_Capstone.FormI9.entity;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Blob;
import java.sql.Timestamp;
import java.util.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "Documents")
@Table(name = "i9_documents")
public class Documents {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="DocumentID", nullable=false)
    private Integer documentID;

    @Column(name = "DocumentType", length=60)
    private String documentType;

    @Column(name = "FormID", length=60)
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

    @Column(name = "DocumentPDF", length=60)
    private Blob documentPDF;

    @Column(name = "created_At", length=60)
    private Timestamp created_At;

    @Column(name = "Modified_At", length=60)
    private Timestamp modified_At;
}



