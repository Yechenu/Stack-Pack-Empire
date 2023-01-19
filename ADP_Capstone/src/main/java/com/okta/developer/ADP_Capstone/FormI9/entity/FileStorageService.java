package com.okta.developer.ADP_Capstone.FormI9.entity;

import com.okta.developer.ADP_Capstone.FormI9.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Objects;
import java.util.stream.Stream;

/*
* The File Storage Service will use FileDBRepository to provide following methods:
*    store(file): receives MultipartFile object, transform to FileDB object and save it to Database
*     getFile(id): returns a FileDB object by provided Id
*     getAllFiles(): returns all stored files as list of code>FileDB objects
*
* @Diamond Brown
* */

@Service
public class FileStorageService {

    @Autowired
    private DocumentRepository documentRepository;

    public Document storeFile(MultipartFile file) throws IOException {
        String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        Document fileDB = new Document(fileName, file.getContentType(), file.getBytes());

        return documentRepository.save(fileDB);
    }

    public Document getFile(String id) {
        return documentRepository.findById(id).get();
    }

    public Stream<Document> getAllFiles() {
        return documentRepository.findAll().stream();
    }
}