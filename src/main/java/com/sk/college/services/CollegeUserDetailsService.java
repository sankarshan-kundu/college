package com.sk.college.services;

import com.sk.college.entity.CollegeUser;
import com.sk.college.model.CollegeUserDetails;
import com.sk.college.repo.CollegeUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CollegeUserDetailsService implements UserDetailsService {
    @Autowired
    private CollegeUserRepository collegeUserRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        CollegeUser collegeUser = collegeUserRepo.findByEmail(username);
        if (collegeUser == null) {
            throw new UsernameNotFoundException("User not found with email: " + username);
        }
        return new CollegeUserDetails(collegeUser);
    }
}
