package com.okta.developer.ADP_Capstone.Applicant.controller;


import com.okta.developer.ADP_Capstone.Applicant.entity.Applicant;
import com.okta.developer.ADP_Capstone.Applicant.payload.Applicant_Request;
import com.okta.developer.ADP_Capstone.Applicant.repository.ApplicantRepository;
import com.okta.developer.ADP_Capstone.Applicant.service.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;


@CrossOrigin("*")
@RestController
@RequestMapping( "capstoneApi/auth/Applicant")
public class ApplicantController {

    @Autowired
    ApplicantService applicantService;
    @Autowired
    ApplicantRepository applicantRepository;

    public ApplicantController(ApplicantService applicantService, ApplicantRepository applicantRepository) {
        this.applicantService = applicantService;
        this.applicantRepository = applicantRepository;
    }

    @GetMapping("/getlist")
    public List<Applicant> getApplicant() {
        return this.applicantRepository.findAll();
    }


    @PostMapping("/post")
    public Applicant completeApplicant(@RequestBody Applicant_Request request) throws URISyntaxException{
        Applicant savedApplicant = applicantService.setApplicant(request);
        applicantService.save(savedApplicant);
        return ResponseEntity.created(
                new URI("/applicant/" + savedApplicant.getApplicantID())).body(savedApplicant).getBody();
    }
}
