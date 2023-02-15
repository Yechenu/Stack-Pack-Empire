package com.okta.developer.ADP_Capstone.Personell.entity;

//import jakarta.persistence.*;
import com.okta.developer.ADP_Capstone.AppUser.models.AppUser;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.sql.Date;

@EntityListeners(AuditingEntityListener.class)
@Table(name = "applicant")
@Entity
public class Applicant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long applicantID;
    private String applicant_Fname;
    private String applicant_Lname;
    private String eVerifyStatus;
    private Date applicant_StartDate;
    private String applicant_City;
    private String applicant_State;
    private String applicant_Country;
    @ManyToOne   //many applicants to one userId
    @JoinColumn(name = "app_id_user_id")
    private AppUser appId;

    public AppUser getAppId() {
        return appId;
    }

    public void setAppId(AppUser appId) {
        this.appId = appId;
    }
    // private int reviewer;
    // private int formID;
    // private int locationID;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "form_id", referencedColumnName = "formID")
//    private Form_I9 form_i9;
//
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "employee_id", referencedColumnName = "employeeID")
//    private Employee employee;
//
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "location_id", referencedColumnName = "locationID")
//    private Location location;


    public Applicant() {
    }
}