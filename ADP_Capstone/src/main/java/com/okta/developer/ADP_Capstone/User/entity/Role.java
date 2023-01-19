package com.okta.developer.ADP_Capstone.User.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="role")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "created_at", "updated_at" }, allowGetters = true)
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "roleID", nullable = false)
    private Long roleID;

    @Column(name= "role",length=60, nullable = false, unique = true) //unique key: Search for a role by role name
    private String role;

    //many-to-many relationship. /roles will display users
    @OneToOne(mappedBy= "roleID", cascade = CascadeType.ALL)
    // indicates that the pk of the Role entity is used as the fk for the associated Role entity.
    private User userID;


    //Security parameter. Every table should have a creat/modified at column
    @CreatedDate
    private Date created_at;  @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updated_at;



}