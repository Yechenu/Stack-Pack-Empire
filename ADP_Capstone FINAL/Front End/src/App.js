import React, { useState, useEffect } from "react";
import { Routes, Route, Link } from "react-router-dom";
import "bootstrap/dist/css/bootstrap.min.css";
import "./Login.css";
import logo from "./assets/adpLogo.png"
import avatar from "./assets/avatar.svg"

import AuthService from "./services/auth.service";

import Login from "./components/Login";
import Register from "./components/Register";

import Profile from "./components/Profile";

import EventBus from "./common/EventBus";
import BoardAuditor from "./components/BoardAuditor";
import BoardEmployer from "./components/BoardEmployer";
import BoardReviewer from "./components/BoardReviewer";
import BoardApplicant from "./components/BoardApplicant";
import I9FormSection1TEST from "./components/ApplicantDashboard/Section1Troubleshoot/I9FormSection1TEST";
import I9FormSection2 from "./components/ReviewerDashboard/Section2/I9FormSection2";
import UploadFiles from "./components/ApplicantDashboard/FileUploader";

const App = () => {
  const [showApplicantBoard, setshowApplicantBoard] = useState(false);
  const [showReviewerBoard, setshowReviewerBoard] = useState(false);
  const [showEmployerBoard, setshowEmployerBoard] = useState(false);
  const [showAuditorBoard, setshowAuditorBoard] = useState(false);
  const [currentUser, setCurrentUser] = useState(undefined);

  useEffect(() => {
    const user = AuthService.getCurrentUser();

    if (user) {
      setCurrentUser(user);
      setshowApplicantBoard(user.roles.includes("ROLE_APPLICANT"));
      setshowReviewerBoard(user.roles.includes("ROLE_REVIEWER"));
      setshowEmployerBoard(user.roles.includes("ROLE_EMPLOYER"));
      setshowAuditorBoard(user.roles.includes("ROLE_AUDITOR"));
    }

    EventBus.on("logout", () => {
      logOut();
    });

    return () => {
      EventBus.remove("logout");
    };
  }, []);

  const logOut = () => {
    AuthService.logout();
    setshowApplicantBoard(false);
    setshowReviewerBoard(false);
    setshowEmployerBoard(false);
    setshowAuditorBoard(false);
    setCurrentUser(undefined);
  };

  return (
    <div>
      <nav className="navbar navbar-expand-lg navbar-light bg-light">
        <Link to={"/"} className="navbar-brand">
          <img
            src={logo}
            width="230
            "
            height="100"
            class="d-inline-block align-top"
            alt="AdpLogo"
          />
        </Link>
        <div className="navbar-nav mr-auto">
          {/* <li className="nav-item">
            <Link to={"/home"} className="nav-link">
              Home
            </Link>
          </li> */}

          {showApplicantBoard && (
            <li className="nav-item">
              <Link to={"/applicant"} className="nav-link">
                Applicant Dashboard
              </Link>
            </li>
          )}

          {showReviewerBoard && (
            <li className="nav-item">
              <Link to={"/reviewer"} className="nav-link">
                Reviewer Dashboard
              </Link>
            </li>
          )}

          {showEmployerBoard && (
            <li className="nav-item">
              <Link to={"/employer"} className="nav-link">
                Employer Dashboard
              </Link>
            </li>
          )}

          {showAuditorBoard && (
            <li className="nav-item">
              <Link to={"/auditor"} className="nav-link">
                Auditor Dashboard
              </Link>
            </li>
          )}

          {currentUser && (
            <li className="nav-item">
              {/* <Link to={"/user"} className="nav-link">
                User
              </Link> */}
            </li>
          )}
        </div>

        {currentUser ? (
          <div className="navbar-nav ms-auto mb-2 mb-lg-0">
            <li className="nav-item dropdown">
              <a
                class="nav-link dropdown-toggle d-flex align-items-center"
                href="#"
                id="navbarDropdownMenuLink"
                role="button"
                data-mdb-toggle="dropdown"
                aria-expanded="false">
                <img
                  src={avatar}
                  width="100"
                  height="50"
                  class="rounded-circle"
                  alt="Avatar"
                  loading="lazy"
                />

                <Link to={"/profile"} className="nav-link">
                  {currentUser.username}
                </Link>
                <li className="nav-item">
                  <a href="/login" className="nav-link" onClick={logOut}>
                    LogOut
                  </a>
                </li>
              </a>
            </li>
          </div>
        ) : (
          <div className="navbar-nav ml-auto">
            <li className="nav-item">
              <Link to={"/login"} className="nav-link">
                Login
              </Link>
            </li>

            <li className="nav-item">
              <Link to={"/register"} className="nav-link">
                Register
              </Link>
            </li>
          </div>
        )}
      </nav>

      <div className="container mt-3">
        <Routes>
          <Route path="/" element={<Login />} />
          {/* <Route path="/home" element={<Home />} /> */}
          <Route path="/form_section1" element={<I9FormSection1TEST />} />
          <Route path="/form_section2" element={<I9FormSection2 />} />
          <Route path="/form_document" element={<UploadFiles />} />

          <Route path="/login" element={<Login />} />
          <Route path="/register" element={<Register />} />
          <Route path="/profile" element={<Profile />} />
          <Route path="/applicant" element={<BoardApplicant />} />
          <Route path="/reviewer" element={<BoardReviewer />} />
          <Route path="/employer" element={<BoardEmployer />} />
          <Route path="/auditor" element={<BoardAuditor />} />
        </Routes>
      </div>
    </div>
  );
};

export default App;
 <button>
   <td>
     <Link to={"/form_section1"} className="nav-link">
       Begin Section 1
     </Link>
   </td>
 </button>;