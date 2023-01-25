package com.okta.developer.ADP_Capstone.FormI9.controller;


import com.okta.developer.ADP_Capstone.FormI9.entity.Section_1;
import com.okta.developer.ADP_Capstone.FormI9.service.Section1Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "capstoneApi/Section1")
public class Section1Controller {
    private final Section1Service section1Service;


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
}
