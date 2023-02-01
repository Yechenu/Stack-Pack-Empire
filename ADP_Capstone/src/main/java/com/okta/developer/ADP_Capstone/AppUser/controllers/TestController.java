package com.okta.developer.ADP_Capstone.AppUser.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/*Controller for testing Authorization
        There are 4 APIs:
        – /api/test/applicant for users has ROLE_APPLICANT
        – /api/test/reviewer for users has ROLE_REVIEWER
        – /api/test/employer for users has ROLE_EMPLOYER
        – /api/test/auditor for users has ROLE_AUDITOR
        */

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/capstoneApi/test")
public class TestController {
  @GetMapping("/all")
  public String allAccess() {
    return "Public Content.";
  }

  @GetMapping("/applicant")
  @PreAuthorize("hasRole('APPLICANT')")
  public String applicantAccess() {
    return "Applicant Content.";
  }

  @GetMapping("/reviewer")
  @PreAuthorize("hasRole('REVIEWER')")
  public String reviewerAccess() {
    return "Reviewer Content.";
  }

  @GetMapping("/employer")
  @PreAuthorize("hasRole('EMPLOYER')")
  public String employerAccess() {
    return "Employer Content.";
  }

  @GetMapping("/auditor")
  @PreAuthorize("hasRole('AUDITOR')")
  public String auditorAccess() {
    return "Auditor Content.";
  }
}
