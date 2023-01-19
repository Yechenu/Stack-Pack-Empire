package com.okta.developer.ADP_Capstone.User.service;

import com.okta.developer.ADP_Capstone.User.dto.UserDTO;
import com.okta.developer.ADP_Capstone.User.entity.User;

import java.util.List;

public interface UserService {

    void registerUser(UserDTO userDto);

    User findUserByEmail(String email);

    List<UserDTO> findAllUsers();
}

