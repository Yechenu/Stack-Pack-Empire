package com.okta.developer.ADP_Capstone.Employee.exception;

public class RecordNotFoundException extends RuntimeException{
    private String errorMessage;

    public RecordNotFoundException(String errorMessage) {
        super();
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }


}