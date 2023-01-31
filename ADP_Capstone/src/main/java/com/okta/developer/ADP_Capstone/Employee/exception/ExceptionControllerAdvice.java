package com.okta.developer.ADP_Capstone.Employee.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(GeneralException.class)
    @ResponseBody
    public ResponseEntity<ErrorResponse> handleException(GeneralException ex){
        ErrorResponse error = new ErrorResponse();
        error.setMessage(ex.getMessage());


        return new ResponseEntity<ErrorResponse>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RecordNotFoundException.class)
    @ResponseBody
    public ResponseEntity<ErrorResponse> handleResourceNotFound(RecordNotFoundException ex){
        ErrorResponse error = new ErrorResponse();
        error.setMessage(ex.getMessage());


        return new ResponseEntity<ErrorResponse>(error, HttpStatus.NOT_FOUND);
    }





}