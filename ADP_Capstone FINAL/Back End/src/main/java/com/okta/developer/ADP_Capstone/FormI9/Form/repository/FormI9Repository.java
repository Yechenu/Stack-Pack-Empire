package com.okta.developer.ADP_Capstone.FormI9.Form.repository;

import com.okta.developer.ADP_Capstone.FormI9.Form.entity.Form_I9;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormI9Repository extends JpaRepository<Form_I9, Long> {

}