import http from "./https-common";

class UploadFilesService {
  upload(file, onUploadProgress) {
    let formData = new FormData();

    formData.append("file", file);

    return http.post("/capstoneApi/formI9/document/uploadFile", formData, {
      headers: {
        "Content-Type": "multipart/form-data",
      },
      onUploadProgress,
    });
  }

  getFiles(file) {
    return http.get(
      "/capstoneApi/formI9/document/downloadFile/{fileName:.+}",
      file
    );
  }
}

export default UploadFilesService;
