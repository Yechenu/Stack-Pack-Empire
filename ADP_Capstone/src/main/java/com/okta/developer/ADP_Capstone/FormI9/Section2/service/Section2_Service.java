package com.okta.developer.ADP_Capstone.FormI9.Section2.service;

import com.okta.developer.ADP_Capstone.FormI9.Section2.entity.Section2;
import com.okta.developer.ADP_Capstone.FormI9.Section2.payload.Section2_Request;
import com.okta.developer.ADP_Capstone.FormI9.Section2.repository.Section2_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Section2_Service {


    @Autowired
    Section2_Repository section2_repository;

    public Section2_Service(Section2_Repository section2_repository){
         
        this.section2_repository=section2_repository;
    }
//handler method to retrive form data
    public Section2 setSection2(Section2_Request request) {
        Section2 savedSection2 = new Section2();
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
    public void save(Section2 section2){
        section2_repository.save(section2);
    }

}
