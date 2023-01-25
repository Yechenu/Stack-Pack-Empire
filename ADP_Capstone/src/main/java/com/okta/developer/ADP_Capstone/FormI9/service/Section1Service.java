package com.okta.developer.ADP_Capstone.FormI9.service;


import com.okta.developer.ADP_Capstone.FormI9.entity.Section_1;
import com.okta.developer.ADP_Capstone.FormI9.repository.Section_1Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Section1Service {

    private final Section_1Repository section_1Repository;

    @Autowired
    public Section1Service(Section_1Repository section_1Repository) {
        this.section_1Repository = section_1Repository;

    }

    public List<Section_1> getSection_1s() {
        return section_1Repository.findAll();
    }


    public void addNewSection1(Section_1 section1) {
    }
}
