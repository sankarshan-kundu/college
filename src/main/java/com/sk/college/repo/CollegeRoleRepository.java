package com.sk.college.repo;

import com.sk.college.model.CollegeRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CollegeRoleRepository extends JpaRepository<CollegeRole, Long> {
    CollegeRole findById(long id);
}
