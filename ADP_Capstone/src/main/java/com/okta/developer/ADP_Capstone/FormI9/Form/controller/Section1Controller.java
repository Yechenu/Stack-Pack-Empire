package com.okta.developer.ADP_Capstone.FormI9.Form.controller;


import com.okta.developer.ADP_Capstone.FormI9.Form.entity.Section_1;
import com.okta.developer.ADP_Capstone.FormI9.Form.service.Section1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "capstoneApi/Section1")
public class Section1Controller {
    private final Section1Service section1Service;

    @Autowired
    public Section1Controller(Section1Service section1Service) {
        this.section1Service = section1Service;
    }

    @GetMapping(path = "/Get")
    public List<Section_1> getSection_1s(){
        return section1Service.getSection_1s();
    }

    @PostMapping(path = "/Post") // Take the RequestBody and Map it into Section 1
    public void NewSection1(@RequestBody Section_1 section_1) {
        section1Service.addNewSection1(section_1);
    }
}
