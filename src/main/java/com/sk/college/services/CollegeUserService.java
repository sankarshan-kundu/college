package com.sk.college.services;

import com.sk.college.model.CollegeUser;
import com.sk.college.repo.CollegeUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollegeUserService {
    @Autowired
    private CollegeUserRepository collegeUserRepo;

    public List<CollegeUser> getAllCollegeUsers() {
        return collegeUserRepo.findAll();
    }
}
