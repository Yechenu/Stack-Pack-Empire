package com.okta.developer.ADP_Capstone.FormI9.message;

/*ResponseMessage.java
* The controller will use  this class for sending message via HTTP responses.
* ResponseMessage for notification/information message
*
* @Diamond
* */

public class ResponseMessage {
    private final String message;

    public ResponseMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}