package com.okta.developer.ADP_Capstone.FormI9.message;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/*ResponseFile.java
 * The controller will use this class for sending messages via HTTP responses.
 * ResponseFile: contains name, url, type, size
 *
 * @Diamond
 * */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseFile {
    private String name;
    private String url;
    private String type;
    private long size;

   /* public ResponseFile(String name, String url, String type, long size) {
        this.name = name;
        this.url = url;
        this.type = type;
        this.size = size;
    }
    */
}
