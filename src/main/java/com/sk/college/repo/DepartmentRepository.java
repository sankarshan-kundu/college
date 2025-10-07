package com.sk.college.repo;

import com.sk.college.entity.Department;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Department findByName(String name);

    @EntityGraph(attributePaths = {"teachers", "teachers.user", "teachers.user.userRoles"})
    List<Department> findAll();
}
