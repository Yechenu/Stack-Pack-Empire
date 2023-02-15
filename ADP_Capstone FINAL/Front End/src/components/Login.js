import React, { useState, useRef } from "react";
import { useNavigate } from 'react-router-dom';
import Form from "react-validation/build/form";
import Input from "react-validation/build/input";
import CheckButton from "react-validation/build/button";
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

const Login = () => {
  let navigate = useNavigate();

  const form = useRef();
  const checkBtn = useRef();

  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [loading, setLoading] = useState(false);
  const [message, setMessage] = useState("");

  const onChangeUsername = (e) => {
    const username = e.target.value;
    setUsername(username);
  };

  const onChangePassword = (e) => {
    const password = e.target.value;
    setPassword(password);
  };

  const handleLogin = (e) => {
    e.preventDefault();

    setMessage("");
    setLoading(true);

    form.current.validateAll();

    if (checkBtn.current.context._errors.length === 0) {
      AuthService.login(username, password).then(
        () => {
          navigate("/profile");
          window.location.reload();
        },
        (error) => {
          const resMessage =
            (error.response &&
              error.response.data &&
              error.response.data.message) ||
            error.message ||
            error.toString();

          setLoading(false);
          setMessage(resMessage);
        }
      );
    } else {
      setLoading(false);
    }
  };

  return (
    <div className="">
      <Row>
        <Col md={6}>
          <Image />
        </Col>{" "}
        <Col md={6}>
          {" "}
          <div className="flex-container">
            {" "}
            <div className="App">
              {" "}
              <Row className="mt-5">
                {" "}
                <span className="adp-onboarding">
                  <h1>ADP Onboarding</h1>{" "}
                </span>{" "}
              </Row>{" "}
              <Row className="login mt-5">
                {" "}
                <h3>
                  {" "}
                  <strong>Sign In</strong>{" "}
                </h3>{" "}
              </Row>{" "}
              <Form onSubmit={handleLogin} ref={form}>
                {" "}
                <div className="form-group mt-5 flex-container-2">
                  {" "}
                  <label htmlFor="username">Username</label>{" "}
                  <Input
                    type="text"
                    className="form-control"
                    name="username"
                    value={username}
                    onChange={onChangeUsername}
                    validations={[required]}
                  />{" "}
                </div>{" "}
                <div className="form-group flex-container-2 mt-2">
                  {" "}
                  <label htmlFor="password">Password</label>{" "}
                  <Input
                    type="password"
                    className="form-control"
                    name="password"
                    value={password}
                    onChange={onChangePassword}
                    validations={[required]}
                  />{" "}
                </div>{" "}
                <div className="form-group mt-3">
                  {" "}
                  <button
                    className="btn  btn-primary btn-lg btn-block"
                    disabled={loading}>
                    {" "}
                    {loading && (
                      <span className="spinner-border spinner-border-sm"></span>
                    )}
                    <span>Login</span>{" "}
                  </button>{" "}
                </div>{" "}
                
                {message && (
                  <div className="form-group">
                    {" "}
                    <div className="alert alert-danger" role="alert">
                      
                      {message}
                    </div>{" "}
                  </div>
                )}
                <CheckButton style={{ display: "none" }} ref={checkBtn} />{" "}
              </Form>{" "}
            </div>{" "}
          </div>{" "}
        </Col>{" "}
      </Row>{" "}
    </div>
  );
};
export default Login;
