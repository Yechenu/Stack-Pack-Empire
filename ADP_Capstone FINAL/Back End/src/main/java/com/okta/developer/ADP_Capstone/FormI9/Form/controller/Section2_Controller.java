package com.okta.developer.ADP_Capstone.FormI9.Form.controller;


import com.okta.developer.ADP_Capstone.FormI9.Form.entity.Section2;
import com.okta.developer.ADP_Capstone.FormI9.Form.payload.Section2_Request;
import com.okta.developer.ADP_Capstone.FormI9.Form.repository.ApplicantRepository;
import com.okta.developer.ADP_Capstone.FormI9.Form.repository.Section2_Repository;
import com.okta.developer.ADP_Capstone.FormI9.Form.service.Section2_Service;
import com.okta.developer.ADP_Capstone.Personell.entity.Applicant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@CrossOrigin("*")
@RestController
@RequestMapping("capstoneApi/auth/applicant/formI9")
public class Section2_Controller {
    @Autowired
    Section2_Service section2_service;
    @Autowired
    Section2_Repository section2_repository;
    private final ApplicantRepository applicantRepository;

    public Section2_Controller(Section2_Service section2_service, Section2_Repository section2_repository,
                               ApplicantRepository applicantRepository) {
        this.section2_service = section2_service;
        this.section2_repository= section2_repository;
        this.applicantRepository = applicantRepository;
    }


//   //build get section 1 by id REST API
//    @GetMapping("{section1_id}")
//    public ResponseEntity<Section1> getSectionId(@PathVariable long id ){
//        Section1 section1 = section_1Repository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException(""));
//        return null;
//    }

//    @GetMapping("/section2")
//    public List<Section2> getSection2(){
//        return this.section2_repository.findAll();
//    }

    // build create employee REST API
    @PostMapping("/completeSection2")
    public Section2 completeSection2(@RequestBody Section2_Request request) throws URISyntaxException {
        Section2 completedSection2 = section2_service.setSection2(request);
        section2_service.save(completedSection2);
        return ResponseEntity.created(
                new URI("/section2/" + completedSection2.getSection2_ID())).body(completedSection2).getBody();
    }

//    @GetMapping("/applicant/{id}")
//    public Applicant getApplicant(@PathVariable Long applicantID) {
//        return applicantRepository.findById(applicantID).orElse(null);
//    }

}