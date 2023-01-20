package com.okta.developer.ADP_Capstone.AppUser.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.okta.developer.ADP_Capstone.Employee.entity.Employee;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;
import java.util.Set;

/*User.java
* This entity file contains the database blueprint of the user table
*  - OneToOne annotation on the related entity field
*  - JoinColumn annotation to configure the name of the column in the users table
*   that maps to the primary key in the address table.
*   If we don't provide a name, Hibernate will follow some rules to select a default one.
*
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
    @Column(name = "userID", nullable = false)
    private Long userId;

    /*@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "roleID", referencedColumnName = "roleID")
    private Role roleID;
*/
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "userID", referencedColumnName = "userID"),
            inverseJoinColumns = @JoinColumn(name = "roleID", referencedColumnName = "roleID"))
    private Set<Role> role;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employeeID", referencedColumnName = "employeeID")
    private Employee employeeID; //change to private Employee employeeID once that entity is made

    @Column(name = "email", length = 60, unique = true, nullable = false)
    private String email;

    @Column(name = "password", length = 60, nullable = false)
    private String password;

    @CreatedDate
    private Date created_at;
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updated_at;


}