package com.okta.developer.ADP_Capstone.User.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*User.java
* This entity file contains the database blueprint of the user table
*
* @Diamond Brown
* */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="user")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "created_at", "updated_at" }, allowGetters = true)
public class User {

    /*Initialize variables (table column names)*/
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long  userID;
    @Column(name = "User_ID", nullable = false)
    private Long employeeID;
    @Column(name = "Employee_ID")
    private String email;
    @Column(name = "Email", unique = true, nullable = false)

    private String password;
    @Column(name = "Password", length=60, nullable = false)

    @CreatedDate
    private Date created_at;
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updated_at;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "roles",
            joinColumns = {@JoinColumn(name = "USER_ID", referencedColumnName = "User_ID")},
            inverseJoinColumns = {@JoinColumn(name = "ROLE_ID", referencedColumnName = "Role_ID")})

    private List<Role> roles = new ArrayList<>();
    @Size(min=5, max=15, message="{register.password.size}")
    private String plainPassword; //unencrytped

    public void setPlainPassword(String plainPassword) {
        //System.out.println("PASSWORD BEFORE " + plainPassword);
        this.password = new BCryptPasswordEncoder().encode(plainPassword);
        //System.out.println("HERE IS PASSWORD" + this.password + "PASSWORD LENGTH = " + (this.password).length());
        this.plainPassword = plainPassword;


    }

    public String getConfirmPassword(){;
        return this.password;
    }

/*Add the Big 3: Class Constructor, Getters and Setters
  Select the "Source" tab and Generate constructors, getters & setters) */
}