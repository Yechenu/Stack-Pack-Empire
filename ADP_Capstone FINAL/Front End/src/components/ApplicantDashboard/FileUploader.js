import React, { useState, useEffect } from "react";
import UploadFilesService from "../../services/FileUploaderServices";
import { Container, Row, Col } from "react-bootstrap";
import list from "../../assets/accordion/listA.png";

import ListItems from "./accordion.js";
import Footer from "../Layout/PageBanner";
import PageBanner from "../Layout/PageBanner";
import Breadcrumb from "react-bootstrap/Breadcrumb";
import { useNavigate } from "react-router-dom";

const UploadFiles = () => {
  const file = new UploadFilesService();
  const navigate = useNavigate();
  const [selectedFiles, setSelectedFiles] = useState(undefined);
  const [currentFile, setCurrentFile] = useState(undefined);
  const [progress, setProgress] = useState(0);
  const [message, setMessage] = useState("");

  const [fileInfos, setFileInfos] = useState([]);

  const selectFile = (event) => {
    setSelectedFiles(event.target.files);
  };

  const handleSubmit = (event) => {
    event.preventDefault();
    navigate("/employee");
  };

  const upload = () => {
    let currentFile = selectedFiles[0];

    setProgress(0);
    setCurrentFile(currentFile);

    file
      .upload(currentFile, (event) => {
        setProgress(Math.round((100 * event.loaded) / event.total));
      })
      .then((response) => {
        setMessage(response.data.message);
        return file.getFiles();
      })
      .then((files) => {
        setFileInfos(files.data);
      })
      .catch(() => {
        setProgress(0);
        setMessage("Could not upload the file!");
        setCurrentFile(undefined);
      });

    setSelectedFiles(undefined);
  };

  useEffect(() => {
    file.getFiles().then((response) => {
      setFileInfos(response.data);
    });
  });

  return (
    <div>
     
      <PageBanner />
      <Container className="mt-5 uploader">
        <form onSubmit={handleSubmit}>
          <Row>
            <Col lg={3}></Col>
            <Col lg={6}>
              <div className="mt-5 ">
                <h3>Form I-9 Acceptable Documents</h3>
                <Breadcrumb>
                  <Breadcrumb.Item href="#">Home</Breadcrumb.Item>
                  <Breadcrumb.Item active>Form I-9 Documents</Breadcrumb.Item>
                </Breadcrumb>
                <h5 className="mt-5">
                  Lists of Acceptable Documents. All documents must be UNEXPIRED
                </h5>

                <p>
                  Employees may present one selection from List A or a
                  combination of one selection from List B and one selection
                  from List C.
                </p>
                <img
                  src={list}
                  alt="list"
                  id="list"
                  width={640}
                  height={100}
                  className="mb-4"
                />

                <ListItems />
              </div>

              {currentFile && (
                <div className="progress">
                  <div
                    className="progress-bar progress-bar-info progress-bar-striped"
                    role="progressbar"
                    aria-valuenow={progress}
                    aria-valuemin="0"
                    aria-valuemax="100"
                    style={{ width: progress + "%" }}>
                    {progress}%
                  </div>
                </div>
              )}

              <label className="btn btn-default">
                <input type="file" onChange={selectFile} />
              </label>

              <button
                className="btn btn-success"
                disabled={!selectedFiles}
                onClick={upload}>
                Upload
              </button>

              <div className="alert alert-light mt-3" role="alert">
                {message}
              </div>

              <div className="card">
                <div className="card-header">List of Files</div>
                <ul className="list-group list-group-flush">
                  {fileInfos &&
                    fileInfos.map((file, index) => (
                      <li className="list-group-item" key={index}>
                        <a href={file.url}>{file.name}</a>
                      </li>
                    ))}
                </ul>
              </div>

              <Row className="mt-5 mb-5">
                <Col></Col>
                <Col>
                  <button
                    type="submit"
                    block
                    style={{
                      background: "white",
                      borderColor: "2B368A",
                      color: "2B368A",
                      width: "275px",
                    }}>
                    <strong>Exit</strong>
                  </button>
                </Col>
                <Col>
                  <button
                    type="submit"
                    block
                    style={{
                      background: "#2B368A",
                      borderColor: "white",
                      color: "white",
                      width: "275px",
                    }}>
                    <strong>Submit</strong>
                  </button>
                </Col>
                <Col></Col>
              </Row>
            </Col>
            <Col lg={3}></Col>
          </Row>
        </form>
      </Container>
      <Footer />
    </div>
  );
};

export default UploadFiles;
