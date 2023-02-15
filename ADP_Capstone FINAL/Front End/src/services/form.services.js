import axios from "axios";

const API_URL = "http://localhost:8082/capstoneApi/auth/applicant/formI9/";

const completeSection1 = (values) => {

  return axios.post(API_URL + "saveSection1", {
    values
     });
  };
  const completeSection2 = (values) => {

  return axios.post(API_URL + "completeSection2", {
    values,
  });
  };
  const FormServices = {
  completeSection1,
  completeSection2

};

export default FormServices;
