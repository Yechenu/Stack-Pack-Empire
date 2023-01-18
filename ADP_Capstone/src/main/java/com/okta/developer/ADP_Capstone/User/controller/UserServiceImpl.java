package com.okta.developer.ADP_Capstone.User.controller;

import com.okta.developer.ADP_Capstone.User.dto.UserDTO;
import com.okta.developer.ADP_Capstone.User.entity.Role;
import com.okta.developer.ADP_Capstone.User.entity.User;
import com.okta.developer.ADP_Capstone.User.repository.RoleRepository;
import com.okta.developer.ADP_Capstone.User.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/*UserServiceImpl.java
* This controller overrides methods created in the UserService repository
* by defining the tasks necessary to interact with the web interface
* (i.e. Login and Activate user)
* @Diamond Brown
* */
@Service
public class UserServiceImpl{

    //instantiate repositories needed
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    //write method to pass and use all repositories at once
    public UserServiceImpl(UserRepository userRepository,
                           RoleRepository roleRepository,
                           PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    //write method that will save User into the database via UserDTO


    public User findUserByEmail(String email) {
        return null;
    }


    public List<UserDTO> findAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map((user) -> mapToUserDto(user))
                .collect(Collectors.toList());
    }
    private UserDTO mapToUserDto(User user){
        UserDTO userDto = new UserDTO();
        userDto.setEmployeeID(user.getEmployeeID());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());

        return userDto;
    }


    //checks for Role listed in database
    private Role checkRoleExist(){
        Role role = new Role();
        role.setRole("ROLE_ADMIN");
        return roleRepository.save(role); //
    }




}
