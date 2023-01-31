package com.okta.developer.ADP_Capstone.Applicant.entity;

import com.okta.developer.ADP_Capstone.Employee.entity.Employee;
import com.okta.developer.ADP_Capstone.Employee.entity.Location;
import com.okta.developer.ADP_Capstone.FormI9.Form.entity.Form_I9;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
@Getter
@Setter
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
    // private int employeeID;
    // private int formID;
    // private int locationID;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "form_id", referencedColumnName = "formID")
    private Form_I9 form_i9;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id", referencedColumnName = "employeeID")
    private Employee employee;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "location_id", referencedColumnName = "locationID")
    private Location location;


    public Applicant(Long applicantID, String applicant_Fname, String applicant_Lname, String eVerifyStatus,
                     Date applicant_StartDate, String applicant_City, String applicant_State, String applicant_Country, int employeeID,
                     int formID, int locationID) {
        this.applicantID = applicantID;
        this.applicant_Fname = applicant_Fname;
        this.applicant_Lname = applicant_Lname;
        this.eVerifyStatus = eVerifyStatus;
        this.applicant_StartDate = applicant_StartDate;
        this.applicant_City = applicant_City;
        this.applicant_State = applicant_State;
        this.applicant_Country = applicant_Country;
        // this.employeeID = employeeID;
        // this.formID = formID;
        // this.locationID = locationID;
    }
}

