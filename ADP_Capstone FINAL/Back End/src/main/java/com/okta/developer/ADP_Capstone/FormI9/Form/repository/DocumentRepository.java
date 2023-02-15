package com.okta.developer.ADP_Capstone.FormI9.Form.repository;

import com.okta.developer.ADP_Capstone.FormI9.Form.entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface DocumentRepository extends JpaRepository<Document, String> {
   List<Document> findByApplicantID(long applicantId);
}