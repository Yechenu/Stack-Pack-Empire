package com.okta.developer.ADP_Capstone.User.dto;

import com.okta.developer.ADP_Capstone.Employee.entity.Employee;
import com.okta.developer.ADP_Capstone.User.entity.Role;
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


    @NotEmpty(message = "EmployeeID should not be empty")
    private Employee employeeID;

    @NotEmpty(message = "Email should not be empty")
    private Role roleID;

    @NotEmpty(message = "Email should not be empty")
    @Email
    private String email;

    @NotEmpty(message = "Password should not be empty")
    private String password;

    @NotEmpty(message = "Confirmed password should not be empty")
    private String confirmPassword;

}