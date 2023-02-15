package com.okta.developer.ADP_Capstone.AppUser.repository;

import java.util.Optional;

import com.okta.developer.ADP_Capstone.AppUser.models.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/*
 *AppUserRepository.java
 * This repository "talks to" (queries) the database for the User entity
 *  - Retrieves the User object by username and email
 *
 * @Diamond Brown
 */

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {
  Optional<AppUser> findByUsername(String username);

  Boolean existsByUsername(String username);

  Boolean existsByEmail(String email);
}
