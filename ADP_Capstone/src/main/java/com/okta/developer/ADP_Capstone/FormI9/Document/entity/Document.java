package com.okta.developer.ADP_Capstone.FormI9.Document.entity;

import com.okta.developer.ADP_Capstone.Personell.entity.Applicant;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Date;
import java.sql.Timestamp;

/*Document.java
 * This entity file contains the database blueprint of the user table
 *  - LOB is datatype for storing large object data.
 *  - JoinColumn annotation to configure the name of the column in the users table
 *   that maps to the primary key in the address table.
 *   If we don't provide a name, Hibernate will follow some rules to select a default one.
 *
 * @Diamond Brown
 * */



@Entity
@Table(name = "document_I9")
public class Document {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name="documentID", nullable=false)
    private String documentID;

    @Column(name= "documentTitle", length = 60)
    private String  documentTitle;

    @Column(name = "listType", length=60)
    private String listType;

    @Column(name = "issuingAuthority", length=60)
    private String issuingAuthority;

    @Column(name = "documentNumber", length=60)
    private Long documentNumber;


    @Column(name = "expirationDate", length=60)
    private Date expirationDate;

    @Column(name = "additionalInfo", length=60)
    private String additionalInfo;

    @Column (name= "fileName")
    private String fileName;

    @Column (name="fileType")
    private String fileType;

    @Lob
    @Column(name ="fileAttachment", length=100000)
    private byte[] fileAttachment;
    @ManyToOne
    @JoinColumn(name = "applicant_id_document")
    private Applicant applicantID;

    @CreationTimestamp
    @Column(name = "created_At", length=60,  nullable = false)
    private Timestamp created_At;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modified_At", length=60, nullable = false)
    private Timestamp modified_At;

    public Applicant getApplicantID() {
        return applicantID;
    }

    public void setApplicantID(Applicant applicantID) {
        this.applicantID = applicantID;
    }

    public Document() {

    }
    public Document(String fileName, String fileType, byte[] fileAttachment) {
        this.fileName= fileName;
        this.fileType= fileType;
        this.fileAttachment= fileAttachment;
    }




    public String getDocumentID() { return this.documentID;}
    public String getFileType() {
        return this.fileType;
    }
    public void setFileType(String fileType){this.fileType = fileType;}
    public String getFileName() {return this.fileName;}
    public void setFileName(String fileName){this.fileName = fileName;}
    public byte[] getFileAttachment() {
        return this.fileAttachment;
    }
    public void setFileAttachment(byte[] fileAttachment) {
         this.fileAttachment = fileAttachment;
    }

}



