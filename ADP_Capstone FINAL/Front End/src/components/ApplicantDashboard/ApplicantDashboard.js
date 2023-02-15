import React, { useState, useEffect } from "react";
import { Link } from "react-router-dom";
import I9FormSection1Test from "../ApplicantDashboard/Section1Troubleshoot/I9FormSection1TEST";
import { Container, Row, Col, Button} from "react-bootstrap";
import { ReactComponent as Image } from "../../assets/forms.svg";
import { ReactComponent as Avatar } from "../../assets/avatar.svg";
import AuthService from "../../services/auth.service";
import axios from "axios";

import PageBanner from "../Layout/PageBanner";

function ApplicantDashboard() {
  const [applicant, setApplicants] = useState([]);
    const currentUser = AuthService.getCurrentUser();
    const user = currentUser.id
  
  useEffect(() => {
    axios
      .get(
        "http://localhost:8082/capstoneApi/auth/applicant/formI9/applicant",
        {
          user
        }
      )
      .then((response) => {
        applicant = AuthService.getCurrentUser();
        // response.data;
      })
      .catch((error) => {
        console.error(error);
      });
  }, []);

  return (
    <div>
      <PageBanner />
      {/* //add the employee dashboard here 
       //create links to navigate to the form */}
      {/* ApplicantDashboard
      <div className="profile_block"> Profile </div>
      <I9FormSection1Test/> */}

      {/* <form onSubmit={handleSubmit}> */}
      <Row>
        <Col xs md={2} className="profile ms-5">
          <Container>
            <Row>
              <Col className="text-center mt-5">
                <Avatar />
                <h5 className="employee">James Oneal</h5>
                <p>Applicant</p>
              </Col>
            </Row>
            <Row className="text-center mt-2">
              <Col>
                <p>Form ID: 0001</p>
              </Col>
            </Row>
          </Container>
        </Col>
        <Col xs md={8} className="dashboard ms-5">
          <Container className="container-2 ">
            <Row className="mt-5 ms-2 ">
              <Col md={3}>
                <div>
                  <Image />
                  <h3 className="ms-1 i9">I-9 Form</h3>
                </div>
              </Col>
              <Col md={3}></Col>
              <Col md={4}>
                <h4 className="due"> 2 activities due.</h4>
              </Col>
              <Col md={2} className="">
                <h1 class="completed">0/2</h1>
                <p>Completed</p>
              </Col>
            </Row>
          </Container>
          <Container className="ms-5 mt-5">
            <Row className="row-title">
              <Col lg={2}>
                <h6 className="title-1">
                  <u>Start Date</u>
                </h6>
              </Col>
              <Col lg={2}>
                <h6 className="title-1">
                  <u>Activity</u>
                </h6>
              </Col>
              <Col lg={2}>
                <h6 className="title-1">
                  <u>Status</u>
                </h6>
              </Col>
              <Col lg={2}>
                <h6 className="title-1">
                  <u>Due Date</u>
                </h6>
              </Col>
              <Col lg={2}>02/06/2023</Col>
            </Row>
            <Row className="mt-4">
              <Col lg={2}></Col>
              <Col lg={2}>I-9 Form: Section 1</Col>
              <Col lg={2}>Not Started</Col>
              <Col lg={2}>02/08/2023</Col>
              <Col lg={2}>
                <Button
                  style={{ backgroundColor: "#2B368A" }}
                  //onClick={onSubmit}
                  //disabled={loading}
                >
                  <Link to={"/form_section1"} className="nav-link">
                    Start
                  </Link>
                </Button>
              </Col>
            </Row>

            <Row className="mt-3">
              <Col lg={2}></Col>
              <Col lg={2}>I-9 Documents</Col>
              <Col lg={2}>Not Started</Col>
              <Col lg={2}></Col>
              <Col lg={2}>
                <Button
                  type="submit"
                  style={{ backgroundColor: "#2B368A" }}
                  //onClick={onSubmit}
                  //disabled={loading}
                >
                 
                  <Link to={"/form_document"} className="nav-link">
                    Start
                  </Link>
                </Button>
              </Col>
            </Row>

            <Row className="mt-5">
              <Col>
                <h5 className="management">Waiting for Management</h5>
              </Col>
            </Row>
            <Row className="mt-4">
              <Col lg={2}></Col>
              <Col lg={2}>I-9 Form: Section 2</Col>
              <Col lg={2}>Not Started</Col>
              <Col lg={2}></Col>
              <Col lg={2}>
                {/* <Button
                  style={{ backgroundColor: "#2B368A" }}
                  //onClick={onSubmit}
                  //disabled={loading}
                >
                  Start
                </Button> */}
              </Col>
            </Row>
          </Container>
        </Col>
      </Row>
      {/* </form> */}

      <footer id="sticky-footer" class="flex-shrink-0 py-4 text-white-50 mt-5">
        <div class="container text-center">
          <small>Copyright &copy; Your Website</small>
        </div>
      </footer>
    </div>
  );
}
export default ApplicantDashboard;
