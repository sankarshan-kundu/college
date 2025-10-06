package com.sk.college.model;

import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@AllArgsConstructor
public class CollegeUserDetails implements UserDetails {

    private final CollegeUser collegeUser;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return collegeUser.getPassword();
    }

    @Override
    public String getUsername() {
        return collegeUser.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return collegeUser.getAccExpiry() == null || collegeUser.getAccExpiry().isAfter(LocalDateTime.now());
    }

    @Override
    public boolean isAccountNonLocked() {
        return !collegeUser.isLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return collegeUser.getCredExpiry() == null || collegeUser.getCredExpiry().isAfter(LocalDateTime.now());
    }

    @Override
    public boolean isEnabled() {
        return collegeUser.isEnabled();
    }
}
