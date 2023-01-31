package com.okta.developer.ADP_Capstone.Employee.entity;



import jakarta.persistence.*;
import lombok.*;
/*
 * Location.java
 * This file contains the location entity for ADP locations
 * @Aladi
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "location")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "locationID")
    private Long locationID; // Primary key locationID auto increment

    @Column(name = "BldgNum")
    private Integer bldgnum;

    @Column(name = "Address")
    private String address;

    @Column(name = "City")
    private String city;

    @Column(name = "State")
    private String state;

    @Column(name = "Country")
    private String country;

}

