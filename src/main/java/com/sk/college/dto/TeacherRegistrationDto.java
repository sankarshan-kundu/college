package com.sk.college.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeacherRegistrationDto {
    private String name;
    private String email;
    private String password;
    private String department;
}
