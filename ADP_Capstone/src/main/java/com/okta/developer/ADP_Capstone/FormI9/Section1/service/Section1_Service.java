package com.okta.developer.ADP_Capstone.FormI9.Section1.service;

import com.okta.developer.ADP_Capstone.FormI9.Section1.entity.Section1;
import com.okta.developer.ADP_Capstone.FormI9.Section1.payload.Section1_Request;
import com.okta.developer.ADP_Capstone.FormI9.Section1.repository.Section1_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Section1_Service {


    @Autowired
     Section1_Repository section1_repository;

    public Section1_Service(Section1_Repository section1_repository){
         this.section1_repository=section1_repository;
    }

    public  Section1 setSection1(Section1_Request request) {
        Section1 savedSection1 = new Section1();
        savedSection1.setLastName(request.getLastName());
        savedSection1.setFirstName(request.getFirstName());
        savedSection1.setMiddleName(request.getMiddleName());
        savedSection1.setOtherNames(request.getOtherNames());
        savedSection1.setAddress(request.getAddress());
        savedSection1.setAptNum(request.getAptNum());
        savedSection1.setCity(request.getCity());
        savedSection1.setState(request.getState());
        savedSection1.setZipCode(request.getZipCode());
        savedSection1.setDob(request.getDob());
        savedSection1.setSsn(request.getSsn());
        savedSection1.setEmail(request.getEmail());
        savedSection1.setPhone(request.getPhone());
        savedSection1.setAttestationNum(request.getAttestationNum());
        savedSection1.setExpirationDate(request.getExpirationDate());
        savedSection1.setUscisNum(request.getUscisNum());
        savedSection1.setFormI94_AdmissionNum(request.getFormI94_AdmissionNum());
        savedSection1.setEmployee_ESign(request.getEmployee_ESign());
        savedSection1.setPreparer_lName(request.getPreparer_lName());
        savedSection1.setPreparer_fName(request.getPreparer_fName());
        savedSection1.setPreparer_Address(request.getPreparer_Address());
        savedSection1.setPreparer_City(request.getPreparer_City());
        savedSection1.setPreparer_State(request.getPreparer_State());
        savedSection1.setPreparer_Zip(request.getPreparer_Zip());
        return savedSection1;
    }
    public void save(Section1 section1){
        section1_repository.save(section1);
    }



}
