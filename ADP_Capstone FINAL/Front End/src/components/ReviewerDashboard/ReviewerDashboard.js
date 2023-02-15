import React from 'react'
import { Link } from "react-router-dom";
import I9FormSection2 from './Section2/I9FormSection2'
import { Container, Row, Col, Button} from "react-bootstrap";
import { ReactComponent as Image } from "../../assets/forms.svg";
import { ReactComponent as Avatar } from "../../assets/avatar.svg";
import PageBanner from "../Layout/PageBanner";

function ReviewerDashboard() {
  return (
    <div>
      <PageBanner />

      {/* //add the employee dashboard here 
       //create links to navigate to the form */}
      {/* <div className="profile_block"> Profile </div>
      <I9FormSection2 /> */}
      <Container>
        <Row>
          <Col lg={5} className="review ms-5">
            <Row className="ms-1 mt-5" id="progress-2">
              <Col lg={5}>
                <h4>Forms In Progress</h4>
              </Col>
              <Col lg={5} className="progress-2">
                <h4>Start Form 2</h4>
                <Button
                  style={{ backgroundColor: "#2B368A" }}
                  //onClick={onSubmit}
                  //disabled={loading}
                >
                  <Link to={"/form_section2"} className="nav-link">
                    Start
                  </Link>
                </Button>
              </Col>
            </Row>
          </Col>

          <Col lg={5} className="review ms-5"></Col>
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
   
export default ReviewerDashboard