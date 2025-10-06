package com.sk.college.repo;

import com.sk.college.model.CollegeUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CollegeUserRepository extends JpaRepository<CollegeUser, Long> {
    CollegeUser findByEmail(String email);
}
