package com.okta.developer.ADP_Capstone.FormI9.repository;

import com.okta.developer.ADP_Capstone.FormI9.entity.Form_I9;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FormI9Repository extends JpaRepository<Form_I9, Long> {

    static void save(ResponseEntity<Form_I9> updateFormI9) {
    }

    List<Form_I9> saveForm_I9s(List<Form_I9> formI9s);

    Form_I9 getFormI9ByName(String name);

    Form_I9 getFormI9ById(long id);
}