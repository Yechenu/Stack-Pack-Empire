package com.okta.developer.ADP_Capstone.Applicant.repository;

import com.okta.developer.ADP_Capstone.Applicant.entity.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicantRepository extends JpaRepository<Applicant, String> {

   
}
