package com.sk.college.services;

import com.sk.college.entity.Teacher;
import com.sk.college.repo.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {
    @Autowired
    private TeacherRepository teacherRepo;

    public void saveTeacher(Teacher teacher) {
        teacherRepo.save(teacher);
    }
}
