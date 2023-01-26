import React from "react";
import NavigationBar from "../components/NavBar";
import PageBanner from "../components/PageBanner";
import "./employeeDashboard.css";
import { Container, Row, Col } from "react-bootstrap";
import { ReactComponent as Image } from "../assets/forms.svg";
import { ReactComponent as Avatar } from "../assets/avatar.svg";

function EmployeeDashboard() {
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
                  <p>Applicant</p>
                </Col>
              </Row>
              <Row className="text-center mt-2">
                <Col>
                  <p>Form ID</p>
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
                    <h3 className="ms-1 color">I-9 Form</h3>
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
            <Container className="ms-5 mt-5">
              <Row>
                <table class="table">
                  <thead>
                    <tr className="color">
                      <th scope="col">Start Date</th>
                      <th scope="col">Activity</th>
                      <th scope="col">Status</th>
                      <th scope="col">Due Date</th>
                      <th scope="col"></th>
                    </tr>
                  </thead>
                  <tbody>
                    <tr>
                      <th scope="row">1</th>
                      <td>Mark</td>
                      <td>Otto</td>
                      <td>@mdo</td>
                    </tr>
                    <tr>
                      <th scope="row">2</th>
                      <td>Jacob</td>
                      <td>Thornton</td>
                      <td>@fat</td>
                    </tr>
                    <tr>
                      <th scope="row">3</th>
                      <td>Larry</td>
                      <td>the Bird</td>
                      <td>@twitter</td>
                    </tr>
                  </tbody>
                </table>
              </Row>

              <Row className="mt-3">
                <Col>
                  <h5 className="management">Waiting for Management</h5>
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

export default EmployeeDashboard;
