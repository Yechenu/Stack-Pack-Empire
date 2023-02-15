package com.okta.developer.ADP_Capstone.FormI9.Form.repository;

import com.okta.developer.ADP_Capstone.AppUser.models.AppUser;
import com.okta.developer.ADP_Capstone.Personell.entity.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ApplicantRepository extends JpaRepository<Applicant, Long> {
    @Query("select a from Applicant a where a.appId = ?1")
    Applicant findByAppId(long appId);
}