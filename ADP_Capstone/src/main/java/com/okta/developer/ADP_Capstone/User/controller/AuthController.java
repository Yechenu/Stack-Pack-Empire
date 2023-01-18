package com.okta.developer.ADP_Capstone.User.controller;

import com.okta.developer.ADP_Capstone.User.dto.UserDTO;
import com.okta.developer.ADP_Capstone.User.entity.User;
import com.okta.developer.ADP_Capstone.User.service.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AuthController {


    /*instantiate UserService interface. Access to tasks:
     *  Save User by User DTO
     *  find user by findUserByEmail
     *  list all Users saved in a UseerDTO list
     *
     * the Model interface extends Validation module and BindingRequest extends spring boot
     *
     * @Diamond Brown
     */

    private UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    // handler method to handle home page request
    @GetMapping("/index")
    public String home() {
        return "index";
    }
    // handler method to handle LOGIN page request
    @GetMapping("/login")
    public String login(){
        return "login";
    }

    // handler method to handle user activation form request
    @GetMapping("/activate")
    public String showActivationForm(Model model) {
        // create model object to store form data
        UserDTO user = new UserDTO();
        model.addAttribute("user", user);
        return "activate";
    }

    // handler method to handle user registration form SUBMIT page request
    @PostMapping("/activation/save")
    public String registration(@Valid @ModelAttribute("user") UserDTO userDto,
                               BindingResult result,
                               Model model, HttpSession session) {


        //save existing user selected from the user table in the database into string "existingUser"
        User existingUser = userService.findUserByEmail(userDto.getEmail());
        //if the fields are fufilled already, return string that says the accountis already activated
        if (existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()) {
            result.rejectValue("email", null,
                    "There is already an account activated with the same email");
        }

        if (result.hasErrors()) {
            model.addAttribute("user", userDto);
            return "/activate";
        }

        userService.saveUser(userDto);
        return "redirect:/register?success";
    }
    // handler method to handle list of users...Use this handler in the employee list probably won't use to list employees
    @GetMapping("/users")
    public String users(Model model){
        List<UserDTO> users = userService.findAllUsers();
        model.addAttribute("users", users);
        return "users";
    }
}

