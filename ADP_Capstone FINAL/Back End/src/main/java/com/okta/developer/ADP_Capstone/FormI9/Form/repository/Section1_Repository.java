package com.okta.developer.ADP_Capstone.FormI9.Form.repository;

import com.okta.developer.ADP_Capstone.FormI9.Form.entity.Section1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public interface Section1_Repository extends JpaRepository <Section1, Long> {

    //Optional<Section_1> findByFnameandLname(String fName, String lName);
//    Section1 save(Section1 request);
}
