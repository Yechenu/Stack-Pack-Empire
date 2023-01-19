package com.okta.developer.ADP_Capstone.User.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.okta.developer.ADP_Capstone.Employee.entity.Employee;
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

import java.util.Date;

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
@Table(name = "user")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "created_at", "updated_at" }, allowGetters = true)
public class User {

    /*Initialize variables (table column names)*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userID", nullable = false)
    private Long  userID;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "roleID", referencedColumnName = "roleID")
    //@JoinColumn(name = "roleID", referencedColumnName = "roleID")
    //inverseJoinColumns = {@JoinColumn(name = "Role_ID", referencedColumnName = "Role_ID")})
    private Role roleID;  //Do the same for other foreign key

   //
   @OneToOne(cascade = CascadeType.ALL)
   @JoinColumn(name = "employeeID", referencedColumnName = "employeeID")
    private Employee employeeID; //change to private Employee employeeID once that entity is made

    @Column(name = "email",length=60, unique = true, nullable = false)
    private String email;

    @Column(name = "password", length=60, nullable = false)
    private String password;

    @CreatedDate
    private Date created_at;
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updated_at;


    @Transient //not included database
    @Size(min=5, max=15, message="{register.password.size}")
    private String plainPassword; //unencrytped

    @OneToOne(orphanRemoval = true)
    @JoinTable(name = "user_employee",
            joinColumns = @JoinColumn(name = "user_userid"),
            inverseJoinColumns = @JoinColumn(name = "employee_employeeid"))
    private Employee employee;


    @Transient
    public void setPlainPassword(String plainPassword) {
        //System.out.println("PASSWORD BEFORE " + plainPassword);
        this.password = new BCryptPasswordEncoder().encode(plainPassword);
        //System.out.println("HERE IS PASSWORD" + this.password + "PASSWORD LENGTH = " + (this.password).length());
        this.plainPassword = plainPassword;


    }
    @Transient
    public String getConfirmPassword(){;
        return this.password;
    }

/*Add the Big 3: Class Constructor, Getters and Setters
  Select the "Source" tab and Generate constructors, getters & setters) */
}