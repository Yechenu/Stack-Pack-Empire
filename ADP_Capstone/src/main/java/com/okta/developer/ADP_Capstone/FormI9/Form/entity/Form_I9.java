package com.okta.developer.ADP_Capstone.FormI9.Form.entity;

import jakarta.persistence.*;
import lombok.*;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.sql.Timestamp;
import java.util.*;

@Builder
@NoArgsConstructor
@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = "form_I9")
public class Form_I9 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   
    private Integer formID;
    private Integer employeeID;
    private Integer section1_ID;
    private Integer section2_ID;
    @CreationTimestamp
    private Timestamp modified_At;
    @CreationTimestamp
    private Timestamp created_At;

    public Form_I9(Integer formID, Integer employeeID, Integer section1_ID, Integer section2_ID, Date modified_At, Date created_At) {
        this.formID = formID;
        this.employeeID = employeeID;
        this.section1_ID = section1_ID;
        this.section2_ID = section2_ID;
        this.modified_At = (Timestamp) modified_At;
        this.created_At = (Timestamp) created_At;
    }
}



