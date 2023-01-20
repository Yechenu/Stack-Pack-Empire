package com.okta.developer.ADP_Capstone.FormI9.message;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*ResponseFile
* This controller contains the data objects storing information for the
* response message controller.
* This info will be sent via HTTP responses.
*
* @Diamond Brown*/
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseFile {
    private String fileName;
    private String url;
    private String fileType;
    private long size;
}
