package com.okta.developer.ADP_Capstone.User.repository;

import com.okta.developer.ADP_Capstone.User.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
 *RoleRepository.java
 * This repository "talks" with the database for the role entity
 *
 * @Diamond Brown
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    //this repository finds role name by unique identifier "roleName"
    Role findByRole(String roleName);
}