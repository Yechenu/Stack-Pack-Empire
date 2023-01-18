package com.okta.developer.ADP_Capstone.User.repository;

import com.okta.developer.ADP_Capstone.User.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/*
*UserRepository.java
* This repository "talks" with the database for the User entity
*
* @Diamond Brown
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

//A repository that finds the users (logins) by email


    User findByEmail(String email);
}