package com.okta.developer.ADP_Capstone.FormI9.Form.service;

import com.okta.developer.ADP_Capstone.FormI9.Form.entity.Section1;
import com.okta.developer.ADP_Capstone.FormI9.Form.payload.Section1_Request;
import com.okta.developer.ADP_Capstone.FormI9.Form.repository.Section1_Repository;
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
        savedSection1.setEmployee_Fname(request.getEmployee_Fname());
        savedSection1.setEmployee_Lname(request.getEmployee_Lname());
        savedSection1.setEmployee_MI(request.getEmployee_MI());
        savedSection1.setEmployee_Oname(request.getEmployee_Oname());
        savedSection1.setEmployee_Address(request.getEmployee_Address());
        savedSection1.setEmployee_AptNum(request.getEmployee_AptNum());
        savedSection1.setEmployee_City(request.getEmployee_City());
        savedSection1.setEmployee_State(request.getEmployee_State());
        savedSection1.setEmployee_Zip(request.getEmployee_Zip());
        savedSection1.setEmployee_DOB(request.getEmployee_DOB());
        savedSection1.setEmployee_SSN(request.getEmployee_SSN());
        savedSection1.setEmployee_Email(request.getEmployee_Email());
        savedSection1.setEmployee_Phone(request.getEmployee_Phone());


        savedSection1.setEmployee_Attestation(request.getEmployee_Attestation());
        savedSection1.setExpirationDate(request.getExpirationDate());
        savedSection1.setUSCISnum(request.getUSCISnum());
        savedSection1.setFormI94_AdmissionNum(request.getFormI94_AdmissionNum());


        savedSection1.setEmployee_ESign(request.getEmployee_ESign());
        savedSection1.setPreparerLname(request.getPreparerLname());
        savedSection1.setPreparerFname(request.getPreparerFname());
        savedSection1.setPreparerAddress(request.getPreparerAddress());
        savedSection1.setPreparerCity(request.getPreparerCity());
        savedSection1.setPreparerState(request.getPreparerState());
        savedSection1.setPreparerZip(request.getPreparerZip());
        return savedSection1;
    }
    public void save(Section1 section1){
        section1_repository.save(section1);
    }




}
