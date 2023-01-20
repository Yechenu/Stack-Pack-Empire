package com.okta.developer.ADP_Capstone.AppUser.service;

import com.okta.developer.ADP_Capstone.AppUser.entity.AppUser;
import com.okta.developer.ADP_Capstone.AppUser.repository.AppUserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Set;
import java.util.stream.Collectors;

/*CustomUserDetailsService.java
* This service class produced the functionality for loading the User Details by identifying the
* employee email.
*
* @Diamond Brown
* */

//@Service
public class CustomUserDetailsService implements UserDetailsService {
    public CustomUserDetailsService() {

    }
    //Instantiate AppUser repository
    private AppUserRepository appUserRepo;


    public CustomUserDetailsService(AppUserRepository appUserRepo) {
        this.appUserRepo = appUserRepo;
    }


    //this method is implemented from the UserDetailsService interface layer
    //Looks up UserDetails for a given username
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser user = appUserRepo.findByUsername(username)
        .orElseThrow(() ->
                        new UsernameNotFoundException("User not found with email: " + username));
        //returns User Details by identifying the employee's email
        //return appUserRepo.findByEmail(employeeEmail);

        Set<GrantedAuthority> authorities = user
                .getRoles()
                .stream()
                .map(roles -> new SimpleGrantedAuthority(roles.getRole().name())).collect(Collectors.toSet());

        return new org.springframework.security.core.userdetails.User(user.getUsername(),
                user.getPassword(),
                authorities);
    }
}
