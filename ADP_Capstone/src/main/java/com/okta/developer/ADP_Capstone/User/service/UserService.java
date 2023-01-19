package com.okta.developer.ADP_Capstone.User.service;

import com.okta.developer.ADP_Capstone.User.dto.UserDTO;
import com.okta.developer.ADP_Capstone.User.entity.User;
import com.okta.developer.ADP_Capstone.Employee.entity.Employee;

import java.util.List;

public interface UserService {

    void registerUser(UserDTO userDto);

    User findUserByEmail(String email);  //used to validate login

    List<UserDTO> findAllUsers();

   Employee findByEmail(String email);  //used to validate registration


}

