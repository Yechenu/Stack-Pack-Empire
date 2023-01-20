package com.okta.developer.ADP_Capstone.AppUser.service;

import com.okta.developer.ADP_Capstone.AppUser.repository.AppUserRepository;
import com.okta.developer.ADP_Capstone.AppUser.repository.RoleRepository;
import com.okta.developer.ADP_Capstone.Employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
/*UserService
 * This service file provides the business functionalities for login and register
 * - Find user by email
 * - Find employee by email
 * - Register User
 * - Login User
 *
 * @Diamond Brown
 * */
@Primary
@Service
public class UserService extends CustomUserDetailsService {
//instantiate entity repositories and PasswordEncoder
    private  AppUserRepository appUserRepo;
    private RoleRepository roleRepo;
    private EmployeeRepository employeeRepo;
    private PasswordEncoder passwordEncoder;


    @Autowired
    //The person object will be injected into the property person at run time
    public UserService(AppUserRepository appUserRepo, RoleRepository roleRepo,
                       EmployeeRepository employeeRepo, PasswordEncoder passwordEncoder){
        super();
        this.appUserRepo = appUserRepo;
        this.roleRepo = roleRepo;
        this.employeeRepo = employeeRepo;
        this.passwordEncoder = passwordEncoder;
    }
    //returns boolean. "If user email exists when logging in..."
    public boolean appUserEmailExists(String email){
        return appUserRepo.existsByEmail(email);
    }

    //returns boolean. "If employee email exists when registering..."
    public boolean employeeEmailExists(String email){
        return  employeeRepo.existsByEmail(email);    //used to validate registration
    }

    }






 //used to validate registration





