package com.okta.developer.ADP_Capstone.FormI9.Section2.service;

import com.okta.developer.ADP_Capstone.FormI9.Section2.entity.Section_2;
import com.okta.developer.ADP_Capstone.FormI9.Section2.payload.Section2_Request;
import com.okta.developer.ADP_Capstone.FormI9.Section2.repository.Section_2Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Section2_Service {


    @Autowired
    Section_2Repository section_2repository;

    public Section2_Service(Section_2Repository section_2repository){

        this.section_2repository=section_2repository;
    }
    //handler method to retrive form data
    public Section_2 setSection2(Section2_Request request) {
        Section_2 savedSection2 = new Section_2();
        savedSection2.setEmployeeStartDate(request.getEmployeeStartDate());
        savedSection2.setEmployerSignature(request.getEmployerSignature());
        savedSection2.setDateCompleted(request.getDateCompleted());
        savedSection2.setEmployerTitle(request.getEmployerTitle());
        savedSection2.setEmployer_Fname(request.getEmployer_Fname());
        savedSection2.setEmployer_Lname(request.getEmployer_Lname());
        savedSection2.setEmployer_BusinessName(request.getEmployer_BusinessName());
        savedSection2.setEmployer_BusinessAddress(request.getEmployer_BusinessName());
        savedSection2.setEmployerCity(request.getEmployer_BusinessName());
        savedSection2.setEmployerState(request.getEmployer_BusinessName());
        savedSection2.setEmployerZip(request.getEmployer_BusinessName());
        return savedSection2;
    }
    public void save(Section_2 section_2){
        section_2repository.save(section_2);
    }

}