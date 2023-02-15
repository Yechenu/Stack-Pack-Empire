import axios from "axios";
import authHeader from "./auth-header";

const API_URL = "http://localhost:8082/capstoneApi/test/";

const getPublicContent = () => {
  return axios.get(API_URL + "all");
};

const getApplicantBoard = () => {
  return axios.get(API_URL + "applicant", { headers: authHeader() });
};

const getReviewerBoard = () => {
  return axios.get(API_URL + "reviewer", { headers: authHeader() });
};

const getEmployerBoard = () => {
  return axios.get(API_URL + "employer", { headers: authHeader() });
};
const getAuditorBoard = () => {
  return axios.get(API_URL + "auditor", { headers: authHeader() });
};


const UserService = {
  getPublicContent,
  getApplicantBoard,
  getReviewerBoard,
  getEmployerBoard,
  getAuditorBoard,
};

export default UserService;
