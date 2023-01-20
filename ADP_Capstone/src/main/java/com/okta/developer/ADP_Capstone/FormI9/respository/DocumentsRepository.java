package com.okta.developer.ADP_Capstone.FormI9.respository;

import com.okta.developer.ADP_Capstone.FormI9.entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentsRepository extends JpaRepository<Document, Integer> {
}
