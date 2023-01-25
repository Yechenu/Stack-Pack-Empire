package com.okta.developer.ADP_Capstone.FormI9.Form.controller;




import com.okta.developer.ADP_Capstone.FormI9.Form.entity.Form_I9;
import com.okta.developer.ADP_Capstone.FormI9.Form.exception.ResourceNotFoundException;
import com.okta.developer.ADP_Capstone.FormI9.Form.repository.FormI9Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("/capstoneApi/FormI9")
public class Form_I9Controller {

    @Autowired
    private FormI9Repository repository;

    @GetMapping ("/FindGet")
    public List<Form_I9> all() {
        return repository.findAll();
    }

    @PostMapping ("/CreatePost")
    public Form_I9 createForm_I9(@RequestBody Form_I9 form_i9) {
        return repository.save(form_i9);

    }

    @GetMapping ("/Find/{id}" )
    public ResponseEntity<Form_I9> getForm_I9ById(@PathVariable  long id){
        Form_I9 form_i9 = repository.findById(id)
               .orElseThrow(() -> new ResourceNotFoundException("Form I9 not exist with id:" + id));
        return ResponseEntity.ok(form_i9);
    }

    @PutMapping("/Update/{id}" )
    public ResponseEntity<Form_I9> updateForm_I9(@PathVariable long id, @RequestBody Form_I9 form_i9Details) {
        Form_I9 updateForm_I9 = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Form I9 not exist with id: " + id));


        updateForm_I9.setFormID(form_i9Details.getFormID());
        updateForm_I9.setEmployeeID(form_i9Details.getEmployeeID());
        updateForm_I9.setSection1_ID(form_i9Details.getSection1_ID());
        updateForm_I9.setSection2_ID(form_i9Details.getSection2_ID());
        updateForm_I9.setModified_At(form_i9Details.getModified_At());
        updateForm_I9.setCreated_At(form_i9Details.getCreated_At());



       repository.save(new Form_I9());
        return ResponseEntity.ok(updateForm_I9);

    }
    @DeleteMapping
        public ResponseEntity<Map<String, Boolean>> deleteForm_I9(@PathVariable Long id){
           Form_I9 form_i9 = repository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));

            repository.delete(form_i9);
            Map<String, Boolean> response = new HashMap<>();
            response.put("deleted", Boolean.TRUE);
            return ResponseEntity.ok(response);
        }
    }

