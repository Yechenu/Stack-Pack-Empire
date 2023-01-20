package com.okta.developer.ADP_Capstone.Employee.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
 * Employee.java
 * This file contains the employee entity for ADP employees
 * @Aladi
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employee")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "created_at", "updated_at" }, allowGetters = true)
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Auto increments primary key
    @Column(name="employeeID", nullable=false) // employeeid not null
    private Long employeeID;

    @ManyToOne (cascade = CascadeType.ALL) //One-to-one relationship btw employee and location
    @JoinColumn(name = "locationID",nullable=false)// Foreign key location table
    private Location locationID; // instantiate location entity(object)

    @Column(name = "role", length=60)
    private String role;

    @Column(name = "lName", length=60)
    private String lastName;

    @Column(name = "fName", length=60)
    private String firstName;

    @Column(name = "Email", length=60, unique = true)
    private String email;

    @Column(name = "Phone", length=15)
    private String phone;

    @Column(name = "Address", length=60)
    private String address;

    @Column(name = "zipCode", length=60)
    private String ZipCode;

    @Column(name = "Country", length=60)
    private String country;  @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date created_at;  @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updated_at;


    @Transient
    private List<Employee> employeeList = new ArrayList<>();
}