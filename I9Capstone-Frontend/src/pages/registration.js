import React, { useRef } from "react";
import  {useState} from "react";
import { useForm } from "react-hook-form";
import { ReactComponent as Image } from "../assets/Login.svg";
import axios from "axios";
// import Select from "react-dropdown-select";
import "./registration.css";


function RegisterForm() {
  const {
    register,
    handleSubmit,
    formState: { errors },
  } = useForm();
  
//  added to validate password -DB
  const password = useRef({});
    password.current = ("password", "");
  const onSubmit = async (data) => { 
    // const userData = JSON.parse(localStorage.getItem(data.email));
  
    const response = await axios.post("/capstoneApi/register", data);
    //initialize appUser variable/object
  
    
    
    
  //   if (userData) {
  //     // getItem can return actual value or null
  //     if (userData.password === data.password) {
  //       console.log(userData.name + " You Are Successfully Registered");
  //     } else {
  //       console.log("Email or Password is not matching with our record");
  //     }
  //   } else {
  //     console.log("Email or Password is not matching with our record");
  //   }
  // };
  // The applicant doesn't need to choose their role when they register -DB
  // const options = [
  //   {
  //     value: 1,
  //     label: "Applicant",
  //   },
  //   {
  //     value: 2,
  //     label: "Reviewer",
  //   },
  //   {
  //     value: 3,
  //     label: "Manager",
  //   },
  //   {
  //     value: 4,
  //     label: "Auditor",
  //   },
  // ];
    
  
  return (
    <div className="login">
      <Image />
      <div className="flex-container">
        <span className="adp-onboarding">ADP Onboarding</span>
        <span className="login-1">Registration</span>
        <div className="flex-container-1">
          <form className="App" onSubmit={handleSubmit(onSubmit)}>
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
                type="text"
                name="firstName"
                className="form-control mt-1"
                {...register("text", { required: true })}
                placeholder="Enter First Name"
              />
              {errors.text && (
                <span style={{ color: "red" }}>Field is mandatory </span>
              )}
              <label>Last Name:</label>
              <input
                type="text"
                name="lastName"
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
}
export default RegisterForm;
