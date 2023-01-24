package com.okta.developer.ADP_Capstone.AppUser.repository;

import com.okta.developer.ADP_Capstone.AppUser.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/*
*UserRepository.java
* This repository "talks to" (queries) the database for the User entity
*  - Retrieves the User object by email
*
* @Diamond Brown
 */
@Repository
@Transactional(readOnly = true)
public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    @Transactional
    @Modifying
    @Query("update AppUser a set a.username = ?1")
    void updateUsernameBy(String username);


//A repository that finds the users (logins) by email
Optional<AppUser> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

}