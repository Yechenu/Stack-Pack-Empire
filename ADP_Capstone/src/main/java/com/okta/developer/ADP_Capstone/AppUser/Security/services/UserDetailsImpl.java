package com.okta.developer.ADP_Capstone.Security.config.services;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.okta.developer.ADP_Capstone.AppUser.entity.AppUser;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Getter
@Setter
public class UserDetailsImpl implements UserDetails {
   // @Serial
    private static final long serialVersionUID = 1L;
    private Long userId;

    private String username;

    private String email;

    @JsonIgnore
    private String password;

    public Collection<? extends GrantedAuthority> authorities;

    public UserDetailsImpl(Long userId,
                          String username,
                         String email,
                           String password,
                           Collection<? extends GrantedAuthority> authorities) {
        this.userId = userId;
        this.username = username;//username
       this.email = email;
        this.password = password;
        this.authorities = authorities;
    }
    public static UserDetailsImpl build(AppUser user) {
        List<GrantedAuthority> authorities = user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getName().name()))
                .collect(Collectors.toList());// to set

        return new UserDetailsImpl(
                user.getUserId(),
               user.getUsername(),
                user.getEmail(),
                user.getPassword(),
                authorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        UserDetailsImpl user = (UserDetailsImpl) o;
        return Objects.equals(userId, user.userId);
    }
}

