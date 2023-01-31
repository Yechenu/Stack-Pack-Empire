package com.okta.developer.ADP_Capstone.AppUser.repository;

import java.util.Optional;

import com.okta.developer.ADP_Capstone.AppUser.models.ERole;
import com.okta.developer.ADP_Capstone.AppUser.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
  Optional<Role> findByName(ERole name);
}
