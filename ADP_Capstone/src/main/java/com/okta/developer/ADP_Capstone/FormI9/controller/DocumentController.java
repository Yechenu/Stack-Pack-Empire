package com.okta.developer.ADP_Capstone.FormI9.controller;

import com.okta.developer.ADP_Capstone.FormI9.entity.Document;
import com.okta.developer.ADP_Capstone.FormI9.message.ResponseFile;
import com.okta.developer.ADP_Capstone.FormI9.message.ResponseMessage;
import com.okta.developer.ADP_Capstone.FormI9.service.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;
/*Document.controller
* This controller produces the functionality for uploading and downloading
* documents to and from the database.
*
* @Diamond Brown*/

@CrossOrigin("*") //configures allowed origins
@Controller ("/capstone/api/document")
public class DocumentController {

    @Autowired
    private FileStorageService storageService;

    @PostMapping("/upload")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
        String message = "";
        try {
            storageService.store(file);

            message = "Uploaded the file successfully: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Could not upload the file: " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }
//Handler method that handles storing files into a list
    @GetMapping("/files") //
    public ResponseEntity<List<ResponseFile>> getListFiles() {
        List<ResponseFile> files = storageService.getAllFiles().map(dbFile -> {
            String fileDownloadUri = ServletUriComponentsBuilder
                    .fromCurrentContextPath()
                    .path("/files/")
                    .path(String.valueOf(dbFile.getDocumentID()))
                    .toUriString();
            //Returns response file including: file name, url, type, and size
            return new ResponseFile(
                    dbFile.getFileName(),
                    fileDownloadUri,
                    dbFile.getFileType(),
                    dbFile.getFilePDF().length);
        }).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(files);
    }
    //handler method to download files
    @GetMapping("/files/{id}")
    public ResponseEntity<byte[]> getFile(@PathVariable String id) {
        //store storage service file into the document table
        Document dbFile = storageService.getFile(id);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + dbFile.getFileName() + "\"")
                .body(dbFile.getFilePDF());
    }
}