package com.okta.developer.ADP_Capstone.FormI9.Form.controller;


import com.okta.developer.ADP_Capstone.FormI9.Form.entity.Section_1;
import com.okta.developer.ADP_Capstone.FormI9.Form.exception.ResourceNotFoundException;
import com.okta.developer.ADP_Capstone.FormI9.Form.repository.Section_1Repository;
import com.okta.developer.ADP_Capstone.FormI9.Form.service.Section1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "capstoneApi/Section1")
public class Section1Controller {
    
    @Autowired
    private final Section1Service section1Service;
    private Section_1Repository section_1Repository;

    public Section1Controller(Section1Service section1Service) {
        this.section1Service = section1Service;
    }

    @GetMapping(path = "/Get")
    public List<Section_1> getSection_1s(){
        return section1Service.getSection_1s();
    }
    @PostMapping(path = "/Post") // Add RequestBody to Map Section 1
    public void NewSection1(@RequestBody Section_1 section_1) {
        section1Service.addNewSection1(section_1);
    }

    @GetMapping(path = "/GetID")
    public ResponseEntity<Section_1> getSection_1ById(@PathVariable long id) {
        Section_1 section_1 = section_1Repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Form Id not exist with id:" + id));
        return ResponseEntity.ok(section_1);
    }

    @PutMapping(path = "/Update" )
    public ResponseEntity<Section_1> updateSection_1(@PathVariable long id, @RequestBody Section_1 NewSection1) {
        Section_1 updateSection_1 = section_1Repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Form I9 not exist with id: " + id));


        updateSection_1.setSection1_ID(NewSection1.getSection1_ID());
        updateSection_1.setEmployeeID(NewSection1.getEmployeeID());
        updateSection_1.setFormID(NewSection1.getFormID());;
        updateSection_1.setLName(NewSection1.getLName());
        updateSection_1.setFName(NewSection1.getFName());
        updateSection_1.setMiddle(NewSection1.getMiddle());
        updateSection_1.setOther_Name(NewSection1.getOther_Name());
        updateSection_1.setAddress(NewSection1.getAddress());
        updateSection_1.setAptNum(NewSection1.getAptNum());;
        updateSection_1.setCity(NewSection1.getCity());
        updateSection_1.setState(NewSection1.getState());
        updateSection_1.setZipCode(NewSection1.getZipCode());
        updateSection_1.setDob(NewSection1.getDob());
        updateSection_1.setSsn(NewSection1.getSsn());;
        updateSection_1.setEmail(NewSection1.getEmail());
        updateSection_1.setTelephone(NewSection1.getTelephone());
        updateSection_1.setAttestationNum(NewSection1.getAttestationNum());
        updateSection_1.setExpirationDate(NewSection1.getExpirationDate());
        updateSection_1.setUscisNum(NewSection1.getUscisNum());;
        updateSection_1.setFormI94_admissionNum(NewSection1.getFormI94_admissionNum());
        updateSection_1.setESign(NewSection1.getESign());
        updateSection_1.setPreparerCert(NewSection1.getPreparerCert());;
        updateSection_1.setPreparerEsign(NewSection1.getPreparerEsign());
        updateSection_1.setPreparerLname(NewSection1.getPreparerLname());
        updateSection_1.setPreparerFname(NewSection1.getPreparerFname());
        updateSection_1.setPreparerAddress(NewSection1.getPreparerAddress());
        updateSection_1.setPreparerCity(NewSection1.getPreparerCity());;
        updateSection_1.setPreparerState(NewSection1.getPreparerState());
        updateSection_1.setPreparerZip(NewSection1.getPreparerZip());
        updateSection_1.setCreated_At(NewSection1.getCreated_At());
        updateSection_1.setModified_At(NewSection1.getModified_At());



        section_1Repository.save(new Section_1());
        return ResponseEntity.ok(NewSection1);

    }
}
