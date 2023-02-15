import React from "react";
import NavigationBar from "../components/NavBar";
import PageBanner from "../components/PageBanner";
import "./reviewerDashboard2.css";
import { Container, Row, Col } from "react-bootstrap";
import { ReactComponent as Image } from "../assets/forms.svg";
import { ReactComponent as Avatar } from "../assets/avatar.svg";

function reviewerDashboard2() {
  return (
    <div>
      <NavigationBar />
      <PageBanner />
      <Container>
        <Row>
          <Col xs md={3} className="profile">
            <Container>
              <Row>
                <Col className="text-center mt-5">
                  <Avatar />
                  <h5 className="employee">Employee Name</h5>
                  <p>Role: Reviewer</p>
                </Col>
              </Row>
              <Row className="text-center mt-2">
                <Col>
                  <p>Employee ID</p>
                </Col>
              </Row>
            </Container>
          </Col>
          <Col xs md={9} className="dashboard">
            <Container className="container-2 ">
              <Row className="mt-5 ms-2 ">
                <Col md={3}>
                  <div>
                    <Image />
                    <h3 className="ms-1 color">Reviewer's Dashboard</h3>
                  </div>
                </Col>
                <Col md={3}></Col>
                <Col md={4}>
                  <h4 className="due"> No activities due.</h4>
                </Col>
                <Col md={2} className="">
                  <h1 class="completed">0/0</h1>
                  <p>Completed</p>
                </Col>
              </Row>
            </Container>
          </Col>
        </Row>
      </Container>
      <footer id="sticky-footer" class="flex-shrink-0 py-4 text-white-50 mt-5">
        <div class="container text-center">
          <small>Copyright &copy; Your Website</small>
        </div>
      </footer>
    </div>
  );
}

export default reviewerDashboard2;
