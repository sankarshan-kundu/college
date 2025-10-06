package com.sk.college.repo;

import com.sk.college.entity.CollegeRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CollegeRoleRepository extends JpaRepository<CollegeRole, Long> {
    CollegeRole findByRole(String roleName);
}
