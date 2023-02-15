package com.okta.developer.ADP_Capstone.FormI9.Form.entity;

//import jakarta.persistence.*;
//import lombok.*;
import com.okta.developer.ADP_Capstone.Personell.entity.Applicant;

import javax.persistence.*;

import java.sql.Timestamp;


//@Builder
//@AllArgsConstructor
//@NoArgsConstructor
//@Getter
//@Setter
//@ToString(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "form_I9")
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(discriminatorType = DiscriminatorType.INTEGER)
public class Form_I9 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer formID;

    @OneToOne
    @JoinColumn(name = "applicant_id")
    private Applicant applicant;


    @OneToOne
    @JoinColumn(name = "section1_id")
    private Section1 section1_ID;


    @OneToOne
    @JoinColumn(name = "section2_id")
    private Section2 section2_ID;


    private Timestamp modified_At;


    private Timestamp created_At;

    public Section2 getSection2_ID() {
        return section2_ID;
    }

    public void setSection2_ID(Section2 section2_ID) {
        this.section2_ID = section2_ID;
    }

    public Section1 getSection1_ID() {
        return section1_ID;
    }

    public void setSection1_ID(Section1 section1_ID) {
        this.section1_ID = section1_ID;
    }

    public Applicant getApplicant() {
        return applicant;
    }

    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }


}



