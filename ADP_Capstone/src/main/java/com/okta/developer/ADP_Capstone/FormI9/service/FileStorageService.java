package com.okta.developer.ADP_Capstone.FormI9.service;


import com.okta.developer.ADP_Capstone.FormI9.entity.Document;
import com.okta.developer.ADP_Capstone.FormI9.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Objects;
import java.util.stream.Stream;
/*FileStorageService.java
* This service file contains the functionalities for uploading
* documents as file inputs.
*
* @Diamond Brown
* */

@Service
public class FileStorageService {

    @Autowired
    private DocumentRepository documentRepo;


//store(file): receives MultipartFile object, transform to Document object
// and save it to Database
    public Document store(MultipartFile file) throws IOException {
        //Retrieves document Name from the user and stores in fileName string
        String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        //Stores document details from the
        Document document = new Document(fileName, file.getContentType(), file.getBytes());

        return documentRepo.save(document); //save document in db
    }

    //returns a FileDB object by provided Id
    public Document getFile(String id) {
        return documentRepo.findById(Long.valueOf(id)).get();
    }
    //getAllFiles(): returns all stored files as list of code>FileDB objects
    public Stream<Document> getAllFiles() {
        return documentRepo.findAll().stream();
    }
}
