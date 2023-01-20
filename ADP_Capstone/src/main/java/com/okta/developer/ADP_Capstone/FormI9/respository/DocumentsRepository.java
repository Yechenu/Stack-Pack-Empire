package com.okta.developer.ADP_Capstone.FormI9.respository;

import com.okta.developer.ADP_Capstone.FormI9.entity.Documents;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentsRepository extends JpaRepository<Documents, Integer> {
}
