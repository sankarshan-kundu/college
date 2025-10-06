package com.sk.college.controller;

import com.sk.college.dto.CollegeUserDto;
import com.sk.college.model.CollegeUser;
import com.sk.college.services.CollegeUserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/college-users")
public class CollegeUserController {

    @Autowired
    private CollegeUserService collegeUserService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping()
    public List<CollegeUserDto> getAllCollegeUsers() {
        List<CollegeUser> collegeUsers = collegeUserService.getAllCollegeUsers();
        return collegeUsers.stream()
                .map(user -> modelMapper.map(user, CollegeUserDto.class))
                .toList();
    }
}
