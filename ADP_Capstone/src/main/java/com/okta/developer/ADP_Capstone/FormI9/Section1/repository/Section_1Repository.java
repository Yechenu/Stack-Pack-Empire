package com.okta.developer.ADP_Capstone.FormI9.Section1.repository;

import com.okta.developer.ADP_Capstone.FormI9.Form.entity.Section_1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Section_1Repository extends JpaRepository <Section_1, Integer> {
}
