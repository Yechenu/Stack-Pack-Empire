package com.okta.developer.ADP_Capstone.Blacklist.entity;
import java.sql.Timestamp;


import org.hibernate.annotations.CreationTimestamp;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Data
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