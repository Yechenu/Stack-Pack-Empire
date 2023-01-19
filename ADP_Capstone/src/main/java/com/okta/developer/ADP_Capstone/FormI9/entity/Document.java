package com.okta.developer.ADP_Capstone.FormI9.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
/*Document.java
 * This entity file contains the database blueprint of the user table
 *  - LOB is datatype for storing large object data.
 *  - JoinColumn annotation to configure the name of the column in the users table
 *   that maps to the primary key in the address table.
 *   If we don't provide a name, Hibernate will follow some rules to select a default one.
 *
 * @Diamond Brown
 * */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "document")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "created_at", "updated_at" }, allowGetters = true)
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "documentID", nullable = false)
    private Long  documentID;



    @Column(name = "list_Type")
    private String listType;
    @Column(name = "document_Type")
    private String documentType;
    @Column(name = "issuing_Authority")
    private String issuing_Authority;
    @Column(name = "expiration_Date")
    private String expirationDate;
    @Column(name= "additional_Info")
    private String additionalInfo;

    @Column (name= "fileName")
    private String fileName;
    @Lob
    @Column(name ="filePdf")
    private byte[] filePdf;

    public Document(String fileName, String contentType, byte[] bytes) {
    }

    /*public Document(String listType, String documentType, String issuingAuthority,
                    String expirationDate, InputStream documentPdf) {
        this.listType = listType;
        this.documentType = documentType;
        this.issuingAuthority= issuingAuthority;
        this.expirationDate= expirationDate;
        this.documentPdf = documentPdf;*/

}
