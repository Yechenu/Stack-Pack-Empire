package com.okta.developer.ADP_Capstone.User.controller;

import com.okta.developer.ADP_Capstone.User.dto.UserDTO;
import com.okta.developer.ADP_Capstone.User.entity.User;
import com.okta.developer.ADP_Capstone.User.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
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

    // handler method to handle user registration form request
    @GetMapping("/activate")
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
        User existingUser = userService.findUserByEmail(userDto.getEmail());

        if(existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()){
            result.rejectValue("email", null,
                    "There is already an account activated with the same email");
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
