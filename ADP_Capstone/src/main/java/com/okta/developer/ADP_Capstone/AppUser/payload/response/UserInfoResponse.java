package com.okta.developer.ADP_Capstone.AppUser.payload.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserInfoResponse {
        private Long userId;
        private String username;
        private String email;
        private List<String> roles;

    public UserInfoResponse(Long userId,
                            String username,
                            String email, List<String> roles) {
    }
}
