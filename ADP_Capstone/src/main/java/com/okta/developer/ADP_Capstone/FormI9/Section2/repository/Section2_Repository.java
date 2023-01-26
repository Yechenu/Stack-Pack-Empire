package com.okta.developer.ADP_Capstone.FormI9.Section2.repository;

import com.okta.developer.ADP_Capstone.FormI9.Section2.entity.Section2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Section2_Repository extends JpaRepository<Section2, Long> {
}
