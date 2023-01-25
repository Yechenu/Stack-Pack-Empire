package com.okta.developer.ADP_Capstone.FormI9.Document.controller;


import com.okta.developer.ADP_Capstone.FormI9.Document.entity.Document;
import com.okta.developer.ADP_Capstone.FormI9.Document.message.ResponseFile;
import com.okta.developer.ADP_Capstone.FormI9.Document.service.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
/*This controller is for uploading single and multiple files
 * 
 * @Diamond Brown
 * 
 * */
@RestController
@RequestMapping ("/capstoneApi/document")
public class FileUploadController {

    @Autowired
    private FileStorageService fileStorageService;

    @PostMapping(value = "/uploadFile",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    //pass uploaded file through 'uploadFile' @RequestParam. 
    public ResponseFile uploadFile(@RequestParam(value = "file", required = true) MultipartFile file) {
    	Document fileName = null;
    	//Stored uploaded file original name into a Document object(fileName, file.getContentType(), file.getBytes());
         fileName = fileStorageService.saveFile(file);
         

         String fileDownloadUri = "";
        //Store download URI from the following info
         fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
            .path("/capstoneApi/document/downloadFile/")
            .path(fileName.getDocumentID())
            .toUriString();
        
        //ResponseFile(String newFileName, String downloadURI, MultipartFile contentType, MultipartFile fileSize)
        return new ResponseFile(fileName.getFileName(), fileDownloadUri,
            file.getContentType(), file.getSize());
    }

    //pass uploaded files through 'uploadMultipleFiles' @RequestParam & saveFile in a list
    @PostMapping("/uploadMultipleFiles")
    public List < ResponseFile > uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
        
    	return Arrays.asList(files)
            .stream()
            .map(this::uploadFile)
            .collect(Collectors.toList());
    }
}