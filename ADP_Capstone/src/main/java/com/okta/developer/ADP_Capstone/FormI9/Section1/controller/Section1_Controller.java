package com.okta.developer.ADP_Capstone.FormI9.Section1.controller;


import com.okta.developer.ADP_Capstone.FormI9.Section1.entity.Section1;
import com.okta.developer.ADP_Capstone.FormI9.Section1.payload.Section1_Request;
import com.okta.developer.ADP_Capstone.FormI9.Section1.repository.Section1_Repository;
import com.okta.developer.ADP_Capstone.FormI9.Section1.service.Section1_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("capstoneApi/auth/applicant/formI9")
public class Section1_Controller {
    @Autowired
    Section1_Service section1_service;
    @Autowired
    Section1_Repository section1_repository;

    public Section1_Controller( Section1_Service section1_service, Section1_Repository section1_repository) {
        this.section1_service = section1_service;
        this.section1_repository= section1_repository;
    }


//   //build get section 1 by id REST API
//    @GetMapping("{section1_id}")
//    public ResponseEntity<Section1> getSectionId(@PathVariable long id ){
//        Section1 section1 = section_1Repository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException(""));
//        return null;
//    }

    @GetMapping("/section1")
    public List<Section1> getSection1(){
        return this.section1_repository.findAll();
    }

    // build create employee REST API
    @PostMapping("/saveSection1")
    public Section1 completeSection1(@RequestBody Section1_Request request) throws URISyntaxException {
        Section1 savedSection1= section1_service.setSection1(request);
        section1_service.save(savedSection1);
        return ResponseEntity.created(
                new URI("/section1/" + savedSection1.getSection1_id())).body(savedSection1).getBody();
    }

}