package com.okta.developer.ADP_Capstone.AppUser.dto;

import com.okta.developer.ADP_Capstone.AppUser.entity.Role;
import com.okta.developer.ADP_Capstone.Employee.entity.Employee;
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



    @NotEmpty(message = "Employee ID should not be empty")
    private Employee employeeID;

    @NotEmpty(message = "Role should not be empty")
    private Role roleID;

    @NotEmpty(message = "Employee Email is required")
    @Email
    private String email;

    @Size(min = 6, message = "At least 6 characters")
    @NotEmpty(message = "Password should not be empty")
    private String password;
}