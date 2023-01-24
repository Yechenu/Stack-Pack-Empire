package com.okta.developer.ADP_Capstone.AppUser.payload.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Set;

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
public class RegisterRequest {
    @NotBlank
    @Size(min = 2, max = 40)
    private String firstName;
    @NotBlank
    @Size(min = 2, max = 40)
    private String lastName;
    @NotBlank
    @Size(max = 50)
    @Email
    private String email;
    private Set<String> role;
    @NotBlank
  //  @Size(min = 6, max = 40)
    private String password;
}