package com.okta.developer.ADP_Capstone.FormI9.message;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*ResponseFile
 * This payload contains the data objects storing information for the
 * response message controller (via /uploadFile & /uploadMultipleFiles).
 * This info will be sent via HTTP responses.
 *
 * @Diamond Brown*/

@Getter
@Setter
@NoArgsConstructor
public class ResponseFile {


    private String fileName;
    private String fileDownloadUri;
    private String fileType;
    private long size;


    public ResponseFile(String fileName, String fileDownloadUri,
                        String fileType, long l) {
        this.fileName= fileName;
        this.fileDownloadUri= fileDownloadUri;
        this.fileType= fileType;
        this.size= l;

    }
    public String getFileName() {
        return fileName;
    }


    public void setFileName(String fileName) {
        this.fileName = fileName;
    }


    public String getFileDownloadUri() {
        return fileDownloadUri;
    }


    public void setFileDownloadUri(String fileDownloadUri) {
        this.fileDownloadUri = fileDownloadUri;
    }


    public String getFileType() {
        return fileType;
    }


    public void setFileType(String fileType) {
        this.fileType = fileType;
    }


    public long getSize() {
        return size;
    }


    public void setSize(long size) {
        this.size = size;
    }

}