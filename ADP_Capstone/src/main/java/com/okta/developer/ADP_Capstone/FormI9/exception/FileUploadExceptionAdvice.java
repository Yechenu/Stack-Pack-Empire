package com.okta.developer.ADP_Capstone.FormI9.exception;

import com.okta.developer.ADP_Capstone.FormI9.message.ResponseMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
/*
*FileUploadExceptionAdvice.java
* This exception handles file uploads exceeding the Max Upload Size.
* The sizes are defined in the application.properties
*
* @Diamond Brown
 */

    @ControllerAdvice
    public class FileUploadExceptionAdvice extends ResponseEntityExceptionHandler {

        @ExceptionHandler(MaxUploadSizeExceededException.class)
        public ResponseEntity<ResponseMessage> handleMaxSizeException(MaxUploadSizeExceededException exc) {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage("File too large!"));
        }
    }
