package com.okta.developer.ADP_Capstone.AppUser.repository;

import com.okta.developer.ADP_Capstone.AppUser.entity.ERole;
import com.okta.developer.ADP_Capstone.AppUser.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;



public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(ERole name);

}