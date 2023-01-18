package com.okta.developer.ADP_Capstone.User.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*userDTO.java
* This Data Transfer Object (DTO) includes only those details in the DTO class required for the client.
*  The Entity and DTO fields has fields required
*  are required to the Login client.
* @Diamond Brown
*/

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class UserDTO {


    public long getEmployeeID;
    @NotEmpty(message = "EmployeeID should not be empty")
    private Long employeeID;


    @NotEmpty(message = "Email should not be empty")
    @Email
    private String email;
    @NotEmpty(message = "Password should not be empty")
    private String password;

    @NotEmpty(message = "Confirmed password should not be empty")
    private String confirmPassword;


public UserDTO(Long employeeID, String email, String password, String confirmPassword){
    this.employeeID = employeeID;
    this.email = email;
    this.password= password;
    this.confirmPassword= confirmPassword;
}
}