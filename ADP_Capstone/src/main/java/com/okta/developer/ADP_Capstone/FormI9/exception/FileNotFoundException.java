package com.okta.developer.ADP_Capstone.FormI9.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
/*This exception is thrown if the file is not found in the file path
 * 
 * @Diamond Brown
 */

@ResponseStatus(HttpStatus.NOT_FOUND)
public class FileNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public FileNotFoundException(String message) {
        super(message);
    }

    public FileNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}