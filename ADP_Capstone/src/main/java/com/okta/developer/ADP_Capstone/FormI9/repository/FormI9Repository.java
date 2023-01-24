package com.okta.developer.ADP_Capstone.FormI9.repository;

import com.okta.developer.ADP_Capstone.FormI9.entity.Form_I9;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FormI9Repository extends JpaRepository<Form_I9, Long> {

}