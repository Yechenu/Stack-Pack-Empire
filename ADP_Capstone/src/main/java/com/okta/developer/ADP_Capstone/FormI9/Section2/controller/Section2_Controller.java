package com.okta.developer.ADP_Capstone.FormI9.Section2.controller;


import com.okta.developer.ADP_Capstone.FormI9.Section2.entity.Section2;
import com.okta.developer.ADP_Capstone.FormI9.Section2.payload.Section2_Request;
import com.okta.developer.ADP_Capstone.FormI9.Section2.repository.Section2_Repository;
import com.okta.developer.ADP_Capstone.FormI9.Section2.service.Section2_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("capstoneApi/auth/applicant/formI9")
public class Section2_Controller {
    @Autowired
    Section2_Service section2_service;
    @Autowired
    Section2_Repository section2_repository;

    public Section2_Controller(Section2_Service section2_service, Section2_Repository section2_repository) {
        this.section2_service = section2_service;
        this.section2_repository= section2_repository;
    }


//   //build get section 1 by id REST API
//    @GetMapping("{section1_id}")
//    public ResponseEntity<Section1> getSectionId(@PathVariable long id ){
//        Section1 section1 = section_1Repository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException(""));
//        return null;
//    }

    @GetMapping("/section2")
    public List<Section2> getSection2(){
        return this.section2_repository.findAll();
    }

    // build create employee REST API
    @PostMapping("/saveSection2")
    public Section2 completeSection2(@RequestBody Section2_Request request) throws URISyntaxException {
        Section2 savedSection2= section2_service.setSection2(request);
        section2_service.save(savedSection2);
        return ResponseEntity.created(
                new URI("/section1/" + savedSection2.getSection2_ID())).body(savedSection2).getBody();
    }

}