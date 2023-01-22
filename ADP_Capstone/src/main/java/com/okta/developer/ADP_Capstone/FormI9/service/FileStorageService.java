package com.okta.developer.ADP_Capstone.FormI9.service;


import com.okta.developer.ADP_Capstone.FormI9.entity.Document;
import com.okta.developer.ADP_Capstone.FormI9.exception.FileStorageException;
import com.okta.developer.ADP_Capstone.FormI9.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Objects;
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

    public Document store(MultipartFile file) {

        //Retrieves document Name from the user and stores in fileName string
        String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));

        try {
            // Check if the file's name contains invalid characters
            if (fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }

            //Store document details into a Document object
            Document document = new Document(fileName, file.getContentType(), file.getBytes());

            return documentRepo.save(document); //save document in db

        }catch(IOException e) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", e);
        }

    }
    //retrieve a Document object by provided Id
    public Document getFile(Long fileID) {
        return documentRepo.findById(fileID).get();
    }
/*
     //getAllFiles(): returns all stored files as list of code>FileDB objects
     public Stream<Document> getAllFiles() { return
      documentRepo.findAll().stream(); }
*/
}
