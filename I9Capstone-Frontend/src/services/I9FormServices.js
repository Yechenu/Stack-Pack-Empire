import axios from "axios";

const Section1 = "http://localhost:8081/capstoneApi/auth/applicant/formI9/saveSection1";
const Section2 = "http://localhost:8081/capstoneApi/auth/applicant/formI9/saveSection2";

class I9Form_Service {
  //Section1

  completeSection1(section1_Request) {
    return axios.get(Section1, section1_Request);
  }
    //Section2
    completeSection2(section2_Request) {
      return axios.get(Section2, section2_Request);
  }
}
export default I9Form_Service;
