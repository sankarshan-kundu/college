package com.sk.college.dto;

import com.sk.college.entity.CollegeUser;
import lombok.AllArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
public class DepartmentalTeacherDto {
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
}
