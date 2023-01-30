package com.okta.developer.ADP_Capstone.FormI9.Document.controller;

import com.okta.developer.ADP_Capstone.FormI9.Document.entity.Document;
import com.okta.developer.ADP_Capstone.FormI9.Document.service.FileStorageService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*This controller is for downloading a file
 * 
 * @Diamond Brown
 * */

@RestController
@RequestMapping ("/capstoneApi/formI9/document")
public class FileDownloadController {
	
	  @Autowired
	    private FileStorageService fileStorageService;

	  //Pass the file name and HttpServlet request through "downloadFile" parameters
	    @GetMapping("/downloadFile/{fileName:.+}")
	    public ResponseEntity< Resource > downloadFile(@PathVariable String fileName, HttpServletRequest request) {
	        
	    	//Retrieve a Document file name object by its fileID and saveFile into Document object
	        Document fileDB = fileStorageService.getFile(fileName);


	        return ResponseEntity.ok()
	            .contentType(MediaType.parseMediaType(fileDB.getFileType()))
	            .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileDB.getFileName() + "\"")
	            .body(new ByteArrayResource(fileDB.getFileAttachment()));
	    }

	}