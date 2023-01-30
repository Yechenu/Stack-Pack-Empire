package com.okta.developer.ADP_Capstone.Applicant.service;


import com.okta.developer.ADP_Capstone.Applicant.entity.Applicant;
import com.okta.developer.ADP_Capstone.Applicant.payload.Applicant_Request;
import com.okta.developer.ADP_Capstone.Applicant.repository.ApplicantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplicantService {

    @Autowired
    ApplicantRepository applicantRepository;

    public ApplicantService(ApplicantRepository applicantRepository) {
        this.applicantRepository = applicantRepository;
    }
    public Applicant setApplicant(Applicant_Request request) {
        Applicant savedApplicant = new Applicant();
        savedApplicant.setApplicantID(request.getApplicantID());
        savedApplicant.setApplicant_Fname(request.getApplicant_Fname());
        savedApplicant.setApplicant_Lname(request.getApplicant_Lname());
        savedApplicant.setFormID(request.getFormID());
        savedApplicant.setEVerifyStatus(request.getEVerifyStatus());
        savedApplicant.setApplicant_StartDate(request.getApplicant_StartDate());
        savedApplicant.setApplicant_City(request.getApplicant_City());
        savedApplicant.setApplicant_State(request.getApplicant_State());
        savedApplicant.setApplicant_Country(request.getApplicant_Country());
        savedApplicant.setEmployeeID(request.getEmployeeID());

        return savedApplicant;

    }
    public void save(Applicant applicant) {
        applicantRepository.save(applicant);
    }
}
