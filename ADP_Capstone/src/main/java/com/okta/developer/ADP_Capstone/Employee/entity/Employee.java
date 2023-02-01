package com.okta.developer.ADP_Capstone.Employee.entity;

import java.time.Instant;
import java.util.Set;



import com.okta.developer.ADP_Capstone.Blacklist.entity.Blacklist;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;



import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
 * Employee.java
 * This file contains the employee entity for ADP employees
 *
 */

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "employee")
@EntityListeners(AuditingEntityListener.class)
public class Employee {
    @Id // To provide a primary key of our entity
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto increments primary key
    // @Column maps a column name to the field
    @Column(name = "employeeID", nullable = false) // employeeid not null
    private Long employeeID;

    @OneToOne(cascade = CascadeType.ALL) // One to one relationship between employee and location
    @JoinColumn(name = "location_id", referencedColumnName = "locationID") // Foreign key location table
    private Location location; // instantiate location entity(object)

    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<Blacklist> blacklists;

    @Column(name = "Job_Title")
    private String job_title;

    @Column(name = "lName", length = 60)
    private String lastName;

    @Column(name = "fName", length = 60)
    private String firstName;

    @Column(name = "Phone", length = 60)
    private String phone;

    @Column(name = "Email", length = 60)
    private String email;

    @Column(nullable = false, updatable = false)
    @CreatedDate
    private Instant created_at;

    @Column(nullable = false)
    @LastModifiedDate
    private Instant updated_at;
}