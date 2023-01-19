package com.okta.developer.ADP_Capstone.FormI9.repository;

import com.okta.developer.ADP_Capstone.FormI9.entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/*DocuementRepository.java
* This repository extends to the jparepository.Now we can use FileDBRepository
* with JpaRepository‘s methods such as: save(document), findById(id), findAll()
*
* @Diamond Brown
**/

@Repository
public interface DocumentRepository extends JpaRepository<Document, String> {


}