package com.sk.college.controller;

import com.sk.college.dto.TeacherDto;
import com.sk.college.dto.TeacherRegistrationDto;
import com.sk.college.entity.CollegeRole;
import com.sk.college.entity.CollegeUser;
import com.sk.college.entity.Department;
import com.sk.college.entity.Teacher;
import com.sk.college.services.CollegeRoleService;
import com.sk.college.services.CollegeUserService;
import com.sk.college.services.DepartmentService;
import com.sk.college.services.TeacherService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Set;

@RestController
@RequestMapping("/api/teachers")
@PreAuthorize("hasRole('ADMIN')")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @Autowired
    private CollegeUserService collegeUserService;

    @Autowired
    private CollegeRoleService collegeRoleService;

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @Transactional
    public ResponseEntity<TeacherDto> createTeacher(@RequestBody TeacherRegistrationDto teacherRegistrationDtoDto) {
        CollegeRole teacherRole = collegeRoleService.getRoleByName("TEACHER");
        if (teacherRole == null) {
            throw new IllegalStateException("TEACHER role not found in the system. Please contact administrator.");
        }

        CollegeUser collegeUser = modelMapper.map(teacherRegistrationDtoDto, CollegeUser.class);
        collegeUserService.saveCollegeUser(collegeUser, Set.of(teacherRole));

        Department department = departmentService.getDepartmentByName(teacherRegistrationDtoDto.getDepartment());
        if (department == null) {
            throw new IllegalArgumentException("Department " + teacherRegistrationDtoDto.getDepartment() + " not found.");
        }

        Teacher teacher = modelMapper.map(teacherRegistrationDtoDto, Teacher.class);
        teacher.setUser(collegeUser);
        teacher.setDepartment(department);
        teacherService.saveTeacher(teacher);
        TeacherDto teacherDto = modelMapper.map(teacher, TeacherDto.class);

        try {
            return ResponseEntity
                    .created(new URI("/api/teachers/" + teacher.getUser().getExternalId()))
                    .body(teacherDto);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
