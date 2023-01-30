import React, { useRef, useState, useEffect } from "react";
import { useForm } from "react-hook-form";
import { ReactComponent as Image } from "../assets/Login.svg";
import axios from "axios";
import { useNavigate } from "react-router-dom";
import "./registration.css";
import { Button } from "react-bootstrap"
//const USER_REGEX = /^[A-z][A-z0-9-_]{3,23}$/;
const PWD_REGEX = /^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%]).{8,24}$/;
const REGISTER_URL = '/register';
// function RegisterForm() {
//   
const RegisterForm = () => {
  //getters & setters for field values
  const {
    register, handleSubmit, formState: { errors },
  } = useForm();
  const [loading, setLoading] = useState(false); //disables submit button while loading info. Sets load ing 
  const navigate = useNavigate();
  const [firstName, setFirstName] = useState('');
  const [lastName, setLastName] = useState('');
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const confirmPassword = useRef({});
  password.current = ("password", "");
  const onSubmit = async (data) => {

    const response = await axios.post(REGISTER_URL,
      JSON.stringify({ firstName, lastName, email, password }),
      {
        headers: { 'Content-Type': 'application/json' },
        withCredentials: true
      }
    );
    console.log(response?.data);
    console.log(response?.accessToken);
    console.log(JSON.stringify(response))

    //clear state and controlled inputs
    //need value attrib on inputs for this
    setFirstName('');
    setLastName('');
    setEmail('');
    setPassword('');

  } 

  return (
    <div className="register">
      <Image />
      <div className="flex-container">
        <span className="adp-onboarding">ADP Onboarding</span>
        <span className="login-1">Registration</span>
        <div className="flex-container-1">
          <form className="App" onSubmit={handleSubmit}>
            <div className="flex-container-2">
 {/* The applicant doesn't need to select a role when registering. -DB */}
              {/* <label>Select your role:</label>
              <Select
                options={options}
                placeholder="Select role"
                className="dropdown"
              /> */}
              <label>First Name:</label>
                 <input
                type="text" name="firstName" value={firstName}
                //pass setFirstName method through onChange.  
                onChange={(e) => setFirstName(e.target.value)}   //target.value = value from textfield
                className="form-control mt-1"
                {...register("text", { required: true })}
                placeholder="Enter First Name"
              />
               //if the field is empty
              {errors.firstName && (
                <span style={{ color: "red" }}>Field is mandatory </span>
              )}


              <label>Last Name:</label>
              <input
                type="text"
                name="lastName"
                value={lastName}
                onChange={(e) => setLastName(e.target.value)}
                className="form-control mt-1"
                {...register("text", { required: true })}
                placeholder="Enter Last Name"
              />
              {errors.text && (
                <span style={{ color: "red" }}>Field is mandatory </span>
              )}
{/* The applicant doesn't need to create a username. It will be auto-generated with their F/L names - DB */}
              {/* <label>Username:</label>
              <input
                type="text"
                name="username"
                value={username}
                className="form-control mt-1"
                {...register("text", { required: true })}
                placeholder="Enter Username"
              />
              {errors.text && (
                <span style={{ color: "red" }}>Field is mandatory </span>
              )} */}
              <label>Email Address:</label>
              <input
                type="email"
                name="email"
                className="form-control mt-1"
                {...register("email", { required: true })}
                placeholder="Enter email address"
                
              />
              {errors.email && (
                <span style={{ color: "red" }}>*Email* is mandatory </span>
              )}
              <label>Password:</label>
              <input
                type="password"
                name="password"
                value={password}
                className="form-control mt-1"
                {...register("password", { required: true,
                                           minLength: {
                                                  value: 8,
                                                  message: "Password must have at least 8 characters"}
                                                  })}
                placeholder="Enter password"
              />
              {errors.password && (
                              <span style={{ color: "red" }}>*Password* is mandatory </span>
                            )}
       {/* Added a Password confirmation field - DB */}
               <label>Confirm Password:</label>
                <input
                  type="password"
                  name="confirmPassword"
                  className="form-control mt-1"
                  {...register({ validate: value =>
                                 value === password.current || "The passwords do not match"})}
                  placeholder="Confirm password"
                  />
                {errors.password_repeat && <p>{errors.password_repeat.message}</p>}


                <button> <input
                      type={"submit"}
                      style={{ backgroundColor: "#2B368A" }}
                       id="button"
              /></button>
            </div>
          </form>
        </div>
      </div>
    </div>
  );
}

export default RegisterForm;
