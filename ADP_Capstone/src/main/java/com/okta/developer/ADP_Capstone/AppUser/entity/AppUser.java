package com.okta.developer.ADP_Capstone.AppUser.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/*User.java
* This entity file contains the database blueprint of the user table
* 7 fields: userId,fname, lname, username, email, password, roles.
* @Diamond Brown
* */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "app_user")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "created_at", "updated_at" }, allowGetters = true)
public class AppUser {

    /*Initialize variables (table column names)*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userID", nullable = false, length = 20)
    private Long userId;

    @NotBlank
    @Column(name = "fname", length = 20)
    private String fname;

    @NotBlank
    @Column(name = "lname", length = 20)
    private String lname;

    @NotBlank
    @Column(name= "username", length = 20, unique = true)
    private String username;

    @NotBlank
    @Column(name = "email", length = 60, unique = true, nullable = false)
    private String email;

    @NotBlank
    @Column(name = "password", length = 60, nullable = false)
    private String password;

    @CreatedDate
    private Date created_at;
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updated_at;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "userID", referencedColumnName = "userID"),
            inverseJoinColumns = @JoinColumn(name = "roleID", referencedColumnName = "roleID"))
    private Set<Role> roles = new HashSet<>();


    public void setRole(Set<Role> singleton) {
    }
}