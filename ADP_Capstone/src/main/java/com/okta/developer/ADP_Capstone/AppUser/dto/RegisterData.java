package com.okta.developer.ADP_Capstone.AppUser.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

/*userDTO.java
* This Data Transfer Object (DTO) is responsible for getting values from user
*  and passing it to the DAO layer for inserting in database...
*
* @Diamond Brown
*/

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegisterData {

    @NotEmpty
    private String role;

    @NotEmpty(message = "First name should not be empty")
    private String fname;

    @NotEmpty(message = "Last name should not be empty")
    private String lname;

    @NotEmpty(message = "Valid Email is required")
    @Email
    private String email;

    @NotEmpty(message = "Username is required")
    @Email
    private String username;

    @Size(min = 6, message = "At least 6 characters")
    @NotEmpty(message = "Password should not be empty")
    private String password;
}