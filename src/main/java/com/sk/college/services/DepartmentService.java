package com.sk.college.services;

import com.sk.college.entity.Department;
import com.sk.college.repo.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepo;

    public Department getDepartmentByName(String name) {
        return departmentRepo.findByName(name);
    }

    public List<Department> getAllDepartments() {
        return departmentRepo.findAll();
    }
}
