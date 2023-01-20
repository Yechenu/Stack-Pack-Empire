package com.okta.developer.ADP_Capstone.AppUser.controller;

import com.okta.developer.ADP_Capstone.AppUser.dto.LoginData;
import com.okta.developer.ADP_Capstone.AppUser.dto.RegisterData;
import com.okta.developer.ADP_Capstone.AppUser.entity.AppUser;
import com.okta.developer.ADP_Capstone.AppUser.entity.ERole;
import com.okta.developer.ADP_Capstone.AppUser.entity.Role;
import com.okta.developer.ADP_Capstone.AppUser.repository.AppUserRepository;
import com.okta.developer.ADP_Capstone.AppUser.repository.RoleRepository;
import com.okta.developer.ADP_Capstone.AppUser.service.UserService;
import com.okta.developer.ADP_Capstone.Employee.repository.EmployeeRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@CrossOrigin("*")
@RestController
@RequestMapping("/capstone/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;
    private final UserService userService;

    private RoleRepository roleRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;
    private final AppUserRepository appUserRepo;
    private final EmployeeRepository employeeRepo;

    @Autowired
    //The UserService object will be injected into the AuthController at run time
    public AuthController(UserService userService,
                          AppUserRepository appUserRepo,
                          EmployeeRepository employeeRepo) {
        this.userService = userService;
        this.appUserRepo = appUserRepo;
        this.employeeRepo = employeeRepo;
    }

    // handler method that handles the Login/Sign in REST API:
    //  - check existing username/email
    //  - create new User (with ROLE_USER if not specifying role)
    //  - save User to database using UserRepository
    @PostMapping("/login")
    public ResponseEntity<String> authenticateUser(@RequestBody LoginData loginData){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginData.getUsername(), loginData.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        return new ResponseEntity<>("User signed-in successfully!.", HttpStatus.OK);
    }
    // handler method that handles the Register/SignUp REST API:

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody RegisterData registerData){

        // add check for employee email exists in a DB. if it DOES NOT...
        if(appUserRepo.existsByUsername(registerData.getUsername())){
            return new ResponseEntity<>("Error: Username is already taken!", HttpStatus.BAD_REQUEST);
        }

        // add check for username email exists in DB
        if(appUserRepo.existsByEmail(registerData.getEmail())){
            return new ResponseEntity<>("Error: Email is already taken!", HttpStatus.BAD_REQUEST);
        }
        //getEmployeeID, getRole, getEmail, getPassword from the appUser
        // and set in the appUser fields in the db
        AppUser newUser = new AppUser();
        newUser.setFname(registerData.getFname());
        newUser.setLname(registerData.getLname());
        newUser.setEmail(registerData.getEmail());
        newUser.setPassword(passwordEncoder.encode(registerData.getPassword()));
         String strRoles = registerData.getRole();
        Role userRole = roleRepo.findByRole(ERole.valueOf("ROLE_" + strRoles));
        newUser.setRole(Collections.singleton(userRole));

        //Save user entity into DB via userRepository "save()" method
        appUserRepo.save(newUser);
        return  new ResponseEntity<>("Employee portal account activated successfully", HttpStatus.OK);
        }

        // handler method to handle home page request
    @GetMapping("/index")
    public String home(){
        return "index";
    }
    // handler method to handle login request
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    //handler method to handle user registration form request


    // handler method to handle user registration form request
    /*@GetMapping("/activate")
    public String showActivationForm(Model model){
        // create model object to store form data
        UserDTO user = new UserDTO();
        model.addAttribute("user", user);
        return "activate";
    }
    // handler method to handle user registration form submit request
    @PostMapping("/activate/save")
    public String activation(@Valid @ModelAttribute("user") UserDTO userDto,
                               BindingResult result,
                               Model model){
        AppUser existingUser = userService.findUserByEmail(userDto.getEmail());
        Employee existingEmployee= userService.findByEmail((userDto.getEmail()));
//if euser, .getEmail , is not NULL nor an NOT an empty field...
        if(existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()){
            result.rejectValue("email", null,
                    "There is already an account activated with the same email");
        } else {
            assert existingUser != null;
            if (!existingUser.equals(existingEmployee)) {
                result.rejectValue("email", "This email is not an active ADP email address");
            }
        }

        if(result.hasErrors()){
            model.addAttribute("user", userDto);
            return "/activate";
        }

        userService.registerUser(userDto);
        return "redirect:/activate?success";
    }
    // handler method to handle list of users --> Use this method to display employees
    /*@GetMapping("/users")
    public String users(Model model){
        List<UserDto> users = userService.findAllUsers();
        model.addAttribute("users", users);
        return "users";*/
    }
