package com.okta.developer.ADP_Capstone.AppUser.repository;

import com.okta.developer.ADP_Capstone.AppUser.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
/*
 *AppUserRepository.java
 * This repository "talks to" (queries) the database for the User entity
 *  - Retrieves the User object by email
 *
 * @Diamond Brown
 */
@Repository
@Transactional(readOnly = true)
public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    Optional<AppUser> findByEmail(String email);

    Optional<AppUser> findByUsernameOrEmail(String username, String email);

    Optional<AppUser> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

}
