import axios from "axios";

const Login = "http://localhost:8081/capstoneApi/login";

class LoginService {
  getUsername(username) {
    return axios.get(Login);
  }

  getPassword(password) {
    return axios.get(Login);
  }

  getRole(role) {
    return axios.get(Login);
  }
}

export default LoginService;
