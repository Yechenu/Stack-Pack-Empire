package com.okta.developer.ADP_Capstone.FormI9.dto;


import com.okta.developer.ADP_Capstone.Employee.entity.Employee;
import com.okta.developer.ADP_Capstone.AppUser.entity.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DocuementDTO {

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
