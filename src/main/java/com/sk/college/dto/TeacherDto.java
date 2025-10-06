package com.sk.college.dto;

import com.sk.college.entity.CollegeUser;
import com.sk.college.entity.Department;
import lombok.Setter;

import java.util.UUID;

public class TeacherDto {
    @Setter
    private CollegeUser user;

    public UUID getUserId() {
        return user.getExternalId();
    }

    public void setUserId(UUID id) {
        user.setExternalId(id);
    }

    public String getName() {
        return user.getName();
    }

    public void setName(String name) {
        user.setName(name);
    }

    public String getEmail() {
        return user.getEmail();
    }

    public void setEmail(String email) {
        user.setEmail(email);
    }

    @Setter
    private Department department;

    public String getDepartmentName() {
        return department.getName();
    }
    public void setDepartmentName(String departmentName) {
        department.setName(departmentName);
    }
}
