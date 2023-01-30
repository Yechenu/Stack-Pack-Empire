package com.okta.developer.ADP_Capstone.FormI9.Form.entity;


import jakarta.persistence.*;
import lombok.*;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.okta.developer.ADP_Capstone.FormI9.Section1.entity.Section1;
import com.okta.developer.ADP_Capstone.FormI9.Section2.entity.Section_2;

import java.sql.Timestamp;
import java.util.*;


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
    private Long section1_ID;
    private Long section2_ID;
    private Integer documentID;
    @CreationTimestamp
    private Timestamp modified_At;
    @CreationTimestamp
    private Timestamp created_At;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "formi9_section1",
            joinColumns = {
                    @JoinColumn(name = "formi9_id",
                            nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "section1_id",
                            nullable = false, updatable = false)})
    private Set<Section1> section1s = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "formi9_section2",
            joinColumns = {
                    @JoinColumn(name = "formi9_id",
                            nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "section2_id",
                            nullable = false, updatable = false)})
    private Set<Section_2> section_2s = new HashSet<>();




    

    public Form_I9(Integer formID, Integer employeeID, Long section1_ID, Long section2_ID, Integer documentID, Timestamp modified_At, Timestamp created_At) {
        this.formID = formID;
        this.employeeID = employeeID;
        this.section1_ID = section1_ID;
        this.section2_ID = section2_ID;
        this.documentID = documentID;
        this.modified_At = modified_At;
        this.created_At = created_At;
    }
}



