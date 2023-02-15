package com.okta.developer.ADP_Capstone.FormI9.Form.service;

import com.okta.developer.ADP_Capstone.FormI9.Form.entity.Section2;
import com.okta.developer.ADP_Capstone.FormI9.Form.payload.Section2_Request;
import com.okta.developer.ADP_Capstone.FormI9.Form.repository.Section2_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Section2_Service {


    @Autowired
    Section2_Repository section2_repository;

    public Section2_Service(Section2_Repository section2_repository){
         
        this.section2_repository=section2_repository;
    }
//handler method to retrieve form data
    public Section2 setSection2(Section2_Request request) {
        Section2 savedSection2 = new Section2();
        savedSection2.setEmployee_Fname(request.getEmployee_Fname());
        savedSection2.setEmployer_Lname(request.getEmployer_Lname());
        savedSection2.setEmployee_MI(request.getEmployee_MI());
        savedSection2.setEmployee_Citizenship(request.getEmployee_Citizenship());

        /*Document 1*/
        savedSection2.setListCategory1(request.getListCategory1());
        savedSection2.setDocumentTitle1(request.getDocumentTitle1());
        savedSection2.setIssuingAuthority1(request.getIssuingAuthority1());
        savedSection2.setDocumentNum1(request.getDocumentNum1());
        savedSection2.setExpirationDate1(request.getExpirationDate1());

        /*Document 2*/
        savedSection2.setListCategory2(request.getListCategory2());
        savedSection2.setDocumentTitle2(request.getDocumentTitle2());
        savedSection2.setIssuingAuthority2(request.getIssuingAuthority2());
        savedSection2.setDocumentNum2(request.getDocumentNum2());
        savedSection2.setExpirationDate2(request.getExpirationDate2());

        savedSection2.setAdditional_Inf(request.getAdditional_Inf());
        savedSection2.setEmployee_StartDate(request.getEmployee_StartDate());

        /*Employer Information*/
        savedSection2.setEmployerTitle(request.getEmployerTitle());
        savedSection2.setEmployer_Lname(request.getEmployer_Lname());
        savedSection2.setEmployer_Fname(request.getEmployer_Fname());
        savedSection2.setEmployer_BusinessName(request.getEmployer_BusinessName());
        savedSection2.setEmployer_BusinessAddress(request.getEmployer_BusinessName());
        savedSection2.setEmployer_BusinessCity(request.getEmployer_BusinessName());
        savedSection2.setEmployer_BusinessState(request.getEmployer_BusinessName());
        savedSection2.setEmployer_BusinessZip(request.getEmployer_BusinessName());
        savedSection2.setEmployer_Signature(request.getEmployer_Signature());
        savedSection2.setDateCompleted(request.getDateCompleted());
        return savedSection2;
    }
    public void save(Section2 section2){
        section2_repository.save(section2);
    }

}
