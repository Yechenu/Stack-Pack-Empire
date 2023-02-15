package com.okta.developer.ADP_Capstone.AppUser.payload.request;

import java.util.Set;

import javax.validation.constraints.*;
/*This payload holds the data retrieve from the client post request
 and passes it to the DAO layer for it to be inserted in the database...

Required: { username, email, password}*/

public class RegisterRequest {
  @NotBlank
  @Size(min = 3, max = 20)
  private String firstName;
  @NotBlank
  @Size(min = 3, max = 20)
  private String lastName;
  @NotBlank
  @Size(max = 50)
  @Email
  private String email;
  private Set<String> role;
  @NotBlank
  @Size(min = 6, max = 40)
  private String password;

//  public String getUsername() {
//    return username;
//  }
//
//  public void setUsername(String username) {
//    this.username = username;
//  }


  public String getFirstName() {
    return firstName;
  }
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }
  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }

  public Set<String> getRole() {
    return this.role;
  }

  public void setRole(Set<String> role) {
    this.role = role;
  }
}
