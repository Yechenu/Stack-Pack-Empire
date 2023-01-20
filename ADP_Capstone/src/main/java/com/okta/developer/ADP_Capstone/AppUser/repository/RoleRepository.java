package com.okta.developer.ADP_Capstone.AppUser.repository;

import com.okta.developer.ADP_Capstone.AppUser.entity.ERole;
import com.okta.developer.ADP_Capstone.AppUser.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
 *RoleRepository.java
 * This repository "talks" with the database for the role entity
 * - Retrieves the Role Entity by its roleName.
 *
 * @Diamond Brown
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    //this repository finds role name by unique identifier "roleName"
    Role findByRole(ERole roleName);

}