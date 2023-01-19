package com.okta.developer.ADP_Capstone.User.service.impl;

import com.okta.developer.ADP_Capstone.User.dto.UserDTO;
import com.okta.developer.ADP_Capstone.User.entity.User;
import com.okta.developer.ADP_Capstone.User.repository.RoleRepository;
import com.okta.developer.ADP_Capstone.User.repository.UserRepository;
import com.okta.developer.ADP_Capstone.User.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {


    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository,
                           RoleRepository roleRepository,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void registerUser(UserDTO userDto) {
        User user = new User();
        user.setEmployeeID(userDto.getEmployeeID());
        user.setRoleID(userDto.getRoleID());
        user.setEmail(userDto.getEmail());
        // encrypt the password using spring security
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));


       /* Role role = roleRepository.findByName("ROLE_ADMIN");
        if(role == null){
            role = checkRoleExist();
        }
        user.setRoles(Arrays.asList(role));
        */

        userRepository.save(user);
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<UserDTO> findAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map((user) -> mapToUserDto(user))
                .collect(Collectors.toList());
    }

    private UserDTO mapToUserDto(User user) {
        UserDTO userDto = new UserDTO();
        userDto.setEmployeeID(user.getEmployeeID());
        userDto.setRoleID(user.getRoleID());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        return userDto;
    }
    /*private Role checkRoleExist(){
        Role role = new Role();
        role.setName("ROLE_ADMIN");
        return roleRepository.save(role);
    }
    */

}
