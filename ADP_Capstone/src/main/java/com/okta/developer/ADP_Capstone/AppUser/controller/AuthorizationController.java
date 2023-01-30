package com.okta.developer.ADP_Capstone.AppUser.controller;


import com.okta.developer.ADP_Capstone.AppUser.entity.AppUser;
import com.okta.developer.ADP_Capstone.AppUser.entity.ERole;
import com.okta.developer.ADP_Capstone.AppUser.entity.Role;
import com.okta.developer.ADP_Capstone.AppUser.payload.request.LoginRequest;
import com.okta.developer.ADP_Capstone.AppUser.payload.request.RegisterRequest;
import com.okta.developer.ADP_Capstone.AppUser.payload.response.JwtResponse;
import com.okta.developer.ADP_Capstone.AppUser.payload.response.MessageResponse;
import com.okta.developer.ADP_Capstone.AppUser.repository.AppUserRepository;
import com.okta.developer.ADP_Capstone.AppUser.repository.RoleRepository;
import com.okta.developer.ADP_Capstone.Security.jwt.JwtUtils;
import com.okta.developer.ADP_Capstone.Security.services.UserDetailsImpl;
import jakarta.validation.Valid;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/capstoneApi/auth")
public class AuthorizationController {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    AppUserRepository appUserRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl ) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getUserId(),
                userDetails.getUsername(),
                userDetails.getEmail(),
                roles));
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody RegisterRequest registerRequest ) {
//        if (appUserRepository.existsByEmail(signUpRequest.getEmail())) {
//            return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
//        }

        if (appUserRepository.existsByEmail(registerRequest.getEmail())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use!"));
        }

        // Create new user's account
        String fName= registerRequest.getFirstName();
        String lName= registerRequest.getLastName();
        AppUser user = new AppUser();
        user.setFirstName(fName);
        user.setLastName(lName);
        //gemerate username
        user.setUsername(fName.charAt(0) + StringUtils.substring(lName,0,5) +
                registerRequest.getEmail().length());
        user.setEmail(registerRequest.getEmail());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));

        Set<String> strRoles = registerRequest.getRole();
        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            Role userRole = roleRepository.findByName(ERole.ROLE_APPLICANT)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "reviewer":
                        Role reviewerRole = roleRepository.findByName(ERole.ROLE_REVIEWER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(reviewerRole);

                        break;
                    case "employer":
                        Role employerRole = roleRepository.findByName(ERole.ROLE_EMPLOYER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(employerRole);

                        break;
                    case "auditor":
                        Role auditorRole = roleRepository.findByName(ERole.ROLE_AUDITOR)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(auditorRole);

                    default:
                        Role userRole = roleRepository.findByName(ERole.ROLE_APPLICANT)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(userRole);
                }
            });
        }
        user.setRoles(roles);
        appUserRepository.save(user);



        return ResponseEntity.ok(new MessageResponse("User registered successfully! Your username name: "+ user.getUsername()));
    }

   /* @PostMapping("/logout")
    public ResponseEntity<?> logoutUser() {
        ResponseCookie cookie = jwtUtils.getCleanJwtCookie();
        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, cookie.toString())
                .body(new MessageResponse("You have logged out successfully!"));
    }*/
}