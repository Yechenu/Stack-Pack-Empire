import axios from "axios";

const Register = "http://localhost:8081/capstoneApi/register";

class RegistrationService {
    
    registerUser(registerRequest) {
        return axios.get(Register, registerRequest);
    
    }
}

export default RegistrationService;
