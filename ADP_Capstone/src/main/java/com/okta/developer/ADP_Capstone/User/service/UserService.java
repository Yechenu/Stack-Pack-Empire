package com.okta.developer.ADP_Capstone.User.service;

import com.okta.developer.ADP_Capstone.User.dto.UserDTO;
import com.okta.developer.ADP_Capstone.User.entity.User;

import java.util.List;
/*UserService.java
* This interface contains the methods for the User Services (Login and Activate)
* @Diamond Brown
 */




public interface UserService {
//This method will pass the DTO through this method, however,
// the method will be defined in the UserService controller
    void saveUser(UserDTO userDTO);

    User findUserByEmail(String email);

    List<UserDTO> findAllUsers();


}
