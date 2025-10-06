package com.sk.college.repo;

import com.sk.college.entity.CollegeUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CollegeUserRepository extends JpaRepository<CollegeUser, Long> {
    CollegeUser findByEmail(String email);

    boolean existsByEmail(String email);
}
