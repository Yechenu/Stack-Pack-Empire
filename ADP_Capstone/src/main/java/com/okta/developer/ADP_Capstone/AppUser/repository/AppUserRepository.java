package com.okta.developer.ADP_Capstone.AppUser.repository;

import com.okta.developer.ADP_Capstone.AppUser.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/*
*UserRepository.java
* This repository "talks to" (queries) the database for the User entity
*  - Retrieves the User object by email
*
* @Diamond Brown
 */
@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {
//A repository that finds the users (logins) by email

    Optional<AppUser> findByUsername(String username);
    Optional<AppUser> findByPassword(String password);
    // AppUser findByEmail(String email);

    //Returns boolean
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);

    Boolean existsByPassword(String password);




}