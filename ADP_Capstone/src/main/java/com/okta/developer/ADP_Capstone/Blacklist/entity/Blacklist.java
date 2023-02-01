package com.okta.developer.ADP_Capstone.Blacklist.entity;
import java.sql.Timestamp;


import com.okta.developer.ADP_Capstone.Employee.entity.Employee;
import com.okta.developer.ADP_Capstone.FormI9.Form.entity.Form_I9;
import org.hibernate.annotations.CreationTimestamp;
import jakarta.persistence.*;
import lombok.*;



@NoArgsConstructor
@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "blacklist")
public class Blacklist {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    public Integer blacklistID;
    public Integer employeeID;
    private String firstname;
    private String lastname;
    private String status;
    @CreationTimestamp
    private Timestamp created_At;
    @CreationTimestamp
    private Timestamp modified_At;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "employee", nullable = false)
    private Employee employee;


    public Blacklist(Integer blacklistID, int employeeID, String lastname, String firstname, String status, Timestamp created_At, Timestamp modified_At) {

        this.blacklistID = blacklistID;
        this.employeeID = employeeID;
        this.lastname = lastname;
        this.firstname = firstname;
        this.status = status;
        this.created_At = created_At;
        this.modified_At = modified_At;
    }
}