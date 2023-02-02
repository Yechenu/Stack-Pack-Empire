package com.okta.developer.ADP_Capstone.FormI9.Section1.repository;


import com.okta.developer.ADP_Capstone.FormI9.Section1.entity.Section1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Section1_Repository extends JpaRepository<Section1, Integer> {

}