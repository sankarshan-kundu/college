package com.sk.college.services;

import com.sk.college.entity.CollegeRole;
import com.sk.college.repo.CollegeRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CollegeRoleService {
    @Autowired
    private CollegeRoleRepository collegeRoleRepo;

    public CollegeRole getRoleByName(String roleName) {
        return collegeRoleRepo.findByRole(roleName);
    }
}
