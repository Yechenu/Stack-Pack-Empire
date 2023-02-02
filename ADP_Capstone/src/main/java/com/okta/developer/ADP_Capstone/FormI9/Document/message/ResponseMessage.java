package com.okta.developer.ADP_Capstone.FormI9.Document.message;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public class ResponseMessage {
    private String message;

    public ResponseMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;

	}

	
}
