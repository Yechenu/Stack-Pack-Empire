package com.okta.developer.ADP_Capstone.FormI9.Form.service;



import com.okta.developer.ADP_Capstone.FormI9.Form.entity.Section_1;
import com.okta.developer.ADP_Capstone.FormI9.Form.repository.Section_1Repository;
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


    public Section_1 addNewSection1(Section_1 section_1) {
        return section_1;

    }
}
