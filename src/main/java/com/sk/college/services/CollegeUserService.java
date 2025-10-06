package com.sk.college.services;

import com.sk.college.entity.CollegeRole;
import com.sk.college.entity.CollegeUser;
import com.sk.college.repo.CollegeUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
public class CollegeUserService {
    @Autowired
    private CollegeUserRepository collegeUserRepo;

    public List<CollegeUser> getAllCollegeUsers() {
        return collegeUserRepo.findAll();
    }

    public void saveCollegeUser(CollegeUser collegeUser, Set<CollegeRole> roles) {
        if(collegeUserRepo.existsByEmail(collegeUser.getEmail())) {
            throw new IllegalArgumentException("User with email " + collegeUser.getEmail() + " already exists.");
        }

        collegeUser.setExternalId(UUID.randomUUID());

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(12);
        collegeUser.setPassword(passwordEncoder.encode(collegeUser.getPassword()));

        collegeUser.setUserRoles(roles);
        collegeUser.setEnabled(true);

        collegeUserRepo.save(collegeUser);
    }
}
