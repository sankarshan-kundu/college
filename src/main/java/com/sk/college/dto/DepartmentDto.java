package com.sk.college.dto;

import com.sk.college.entity.Teacher;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;
import java.util.stream.Collectors;

public class DepartmentDto {
    @Getter
    @Setter
    private String name;

    @Setter
    private Set<Teacher> teachers;
    public Set<DepartmentalTeacherDto> getDepartmentalTeachers() {
        if(teachers==null) {
            return Set.of();
        }
        return teachers.stream().map(t -> new DepartmentalTeacherDto(t.getUser())).collect(Collectors.toSet());
    }
    public void setDepartmentalTeachers(Set<Teacher> teachers) {
        this.teachers = teachers;
    }
}
