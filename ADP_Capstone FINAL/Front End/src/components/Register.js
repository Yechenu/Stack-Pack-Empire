import React, { useState, useRef, useNavigate } from "react";
import Form from "react-validation/build/form";
import Input from "react-validation/build/input";
import CheckButton from "react-validation/build/button";
import { isEmail } from "validator";
import { ReactComponent as Image } from "../assets/Login.svg";
import { Col, Row } from "react-bootstrap";
import "../Login.css";

import AuthService from "../services/auth.service";

const required = (value) => {
  if (!value) {
    return (
      <div className="alert alert-danger" role="alert">
        This field is required!
      </div>
    );
  }
};

const validEmail = (value) => {
  if (!isEmail(value)) {
    return (
      <div className="alert alert-danger" role="alert">
        This is not a valid email.
      </div>
    );
  }
};

const vfirstName = (value) => {
  if (value.length < 3 || value.length > 20) {
    return (
      <div className="alert alert-danger" role="alert">
        The first name must be between 3 and 20 characters.
      </div>
    );
  }
};
const vlastName = (value) => {
  if (value.length < 3 || value.length > 20) {
    return (
      <div className="alert alert-danger" role="alert">
        The last name must be between 3 and 20 characters.
      </div>
    );
  }
};

const vpassword = (value) => {
  if (value.length < 6 || value.length > 40) {
    return (
      <div className="alert alert-danger" role="alert">
        The password must be between 6 and 40 characters.
      </div>
    );
  }
};

const Register = () => {
  // let navigate = useNavigate();
  const form = useRef();
  const checkBtn = useRef();

  const [firstName, setFirstName] = useState("");
  const [lastName, setLastName] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
   const [loading, setLoading] = useState(false);
  const [message, setMessage] = useState("");
  const [successful, setSuccessful] = useState("");

  const onChangeFirstName = (e) => {
    const firstName = e.target.value;
    setFirstName(firstName);
  };
  const onChangeLastName = (e) => {
    const lastName = e.target.value;
    setLastName(lastName);
  };

  const onChangeEmail = (e) => {
    const email = e.target.value;
    setEmail(email);
  };

  const onChangePassword = (e) => {
    const password = e.target.value;
    setPassword(password);
  };

  const handleRegister = (e) => {
    e.preventDefault();

    setMessage("");
    setSuccessful(false);

    form.current.validateAll();

    if (checkBtn.current.context._errors.length === 0) {
      AuthService.register(firstName, lastName, email, password).then(
        (response) => {
          setMessage(response.data.message);
          setSuccessful(true);
          // navigate("/login");
        },
        (error) => {
          const resMessage =
            (error.response &&
              error.response.data &&
              error.response.data.message) ||
            error.message ||
            error.toString();

          setMessage(resMessage);
          setSuccessful(false);
        }
      );
    }
  };
  return (
    <div className="">
      <Row>
        <Col md={6}>
          <Image />
        </Col>
        <Col md={6}>
          <div className="flex-container">
            <div className="App">
              <Row className="mt-4">
                <span className="adp-onboarding">
                  <h1>ADP Onboarding</h1>
                </span>
              </Row>
              <Row className="login mt-4">
                <h3>
                  <strong>Register</strong>{" "}
                </h3>
              </Row>
              <Form onSubmit={handleRegister} ref={form}>
                {!successful && (
                  <div>
                    <div className="form-group mt-5 flex-container-2">
                      <label htmlFor="firstName">First Name</label>
                      <Input
                        type="text"
                        className="form-control"
                        name="firstName"
                        value={firstName}
                        onChange={onChangeFirstName}
                        validations={[required, vfirstName]}
                      />
                    </div>
                    <div className="form-group flex-container-2 mt-2">
                      <label htmlFor=" lastName">Last Name</label>
                      <Input
                        type="text"
                        className="form-control"
                        name="lastName"
                        value={lastName}
                        onChange={onChangeLastName}
                        validations={[required, vlastName]}
                      />
                    </div>
                    <div className="form-group flex-container-2 mt-2">
                      <label htmlFor="email">Email</label>
                      <Input
                        type="text"
                        className="form-control"
                        name="email"
                        value={email}
                        onChange={onChangeEmail}
                        validations={[required, validEmail]}
                      />
                    </div>
                    <div className="form-group flex-container-2 mt-2">
                      <label htmlFor="password">Password</label>
                      <Input
                        type="password"
                        className="form-control"
                        name="password"
                        value={password}
                        onChange={onChangePassword}
                        validations={[required, vpassword]}
                      />
                    </div>
                    <div className="form-group mt-3">
                      <button
                        className="btn  btn-primary btn-lg btn-block"
                        disabled={loading}>
                        {loading && (
                          <span className="spinner-border spinner-border-sm"></span>
                        )}
                        <span>Sign Up</span>
                      </button>
                    </div>
                  </div>
                )}
                {message && (
                  <div className="form-group">
                    <div className="alert alert-danger" role="alert">
                      {message}
                    </div>
                  </div>
                )}
                <CheckButton style={{ display: "none" }} ref={checkBtn} />
              </Form>
            </div>
          </div>
        </Col>
      </Row>
    </div>
  );
}
  
export default Register;
