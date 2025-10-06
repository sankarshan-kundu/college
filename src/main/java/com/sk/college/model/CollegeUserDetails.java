package com.sk.college.model;

import com.sk.college.entity.CollegeAuthority;
import com.sk.college.entity.CollegeRole;
import com.sk.college.entity.CollegeUser;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
public class CollegeUserDetails implements UserDetails {

    private final CollegeUser collegeUser;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        Set<CollegeRole> roles = collegeUser.getUserRoles();
        for (CollegeRole role : roles) {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRole()));
            Set<CollegeAuthority> roleAuthorities = role.getRoleAuthorities();
            for (CollegeAuthority authority : roleAuthorities) {
                authorities.add(new SimpleGrantedAuthority(authority.getAuthority()));
            }
        }
        return authorities;
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
