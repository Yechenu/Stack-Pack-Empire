package com.okta.developer.ADP_Capstone.AppUser.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.HashSet;
import java.util.Set;

/*User.java
* This entity file contains the database blueprint of the user table
* 7 fields: userId,fname, lname, username, email, password, roles.
*
* @Diamond Brocom.okta.developer.ADP_Capstone.AppUser.entity.AppUser findByFirstName(java.lang.String firstName);com.okta.developer.ADP_Capstone.AppUser.entity.AppUser findByFirstName(java.lang.String firstName);wn
* */

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "app_user",
        uniqueConstraints = {
        @UniqueConstraint(columnNames = "email")
})
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "created_at", "updated_at" }, allowGetters = true)
public class AppUser {

    /*Initialize variables (table column names)*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userID", nullable = false, length = 20)
    private Long userId;
    // @Column(name = "firstName", length = 20, nullable = false)
    @NotBlank
    @Size(min = 2, max = 40)
    private String firstName;
    // @Column(name = "lastName", length = 20, nullable = false)
    @NotBlank
    @Size(min = 2, max = 40)
    private String lastName;
   /* @Column (name = "employeeID")
    private Employee employeeID;*/

    // @Column(name = "email", length = 60, unique = true, nullable = false)
    @NotBlank
    @Size(max = 50)
    @Email
    private String email;
    //@Column(name = "username", length = 20)
    @NotBlank
    private String username;
    //@Column(name = "password", length = 60, nullable = false)
    @NotBlank
   // @Size(min = 6, max = 40)
    private String password;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public AppUser(String firstName, String lastName,
                   String email, String password, String s) {
        this.firstName = firstName;
        this.lastName = lastName;
       // this.username= username;
        this.email = email;
        this.password = password;
    }


}

