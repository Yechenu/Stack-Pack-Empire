package com.okta.developer.ADP_Capstone.Blacklist.entity;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;


@NoArgsConstructor
@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
@Entity(name = "Blacklist")
@Table(name = "blacklist")
@EntityListeners(AuditingEntityListener.class)
public class Blacklist {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    public Integer blacklistID;
    public Integer employeeID;
    private String lName;
    private String fName;
    private String status;
    @CreatedDate
    private Date created_At;
    @LastModifiedDate
    private Date modified_At;


    public Blacklist(Integer blacklistID, Integer employeeID, String lName, String fName, String status, Date created_At, Date modified_At) {

        this.blacklistID = blacklistID;
        this.employeeID = employeeID;
        this.lName = lName;
        this.fName = fName;
        this.status = status;
        this.created_At = created_At;
        this.modified_At = modified_At;
    }
}