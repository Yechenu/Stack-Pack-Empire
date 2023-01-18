package com.okta.developer.ADP_Capstone.Employee.entity;
import javax.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener; 
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
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
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "created_at", "updated_at" }, allowGetters = true)
public class Location { 
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "locationID")
  private Long locationID;  // Primary key locationID auto increment

  @OneToOne(mappedBy= "locationID", cascade = CascadeType.ALL) // LocationID foreign key in employee table
private Employee employeeID;

@Column(name = "Phone")
private int phone;

@Column(name = "Address")
private String address;

@Column(name = "City")
private String city;

@Column(name = "State")
private String state;

@Column(name = "Country")
  private String country;  @Column(nullable = false, updatable = false)
  @Temporal(TemporalType.TIMESTAMP)
  @CreatedDate
  private Date created_at;  @Column(nullable = false)
  @Temporal(TemporalType.TIMESTAMP)
  @LastModifiedDate
  private Date updated_at;  
}
	