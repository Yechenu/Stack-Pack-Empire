package com.okta.developer.ADP_Capstone.User.service;

import com.okta.developer.ADP_Capstone.User.dto.UserDTO;
import com.okta.developer.ADP_Capstone.User.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class DefaultUserService implements UserService{

    @Override
    public void registerUser(UserDTO userDto) {

    }

    @Override
    public User findUserByEmail(String email) {
        return null;
    }

    @Override
    public List<UserDTO> findAllUsers() {
        return null;
    }
}
