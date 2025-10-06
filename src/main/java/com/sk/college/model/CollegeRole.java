package com.sk.college.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "COLLEGE_ROLES")
@NoArgsConstructor
@Getter
@Setter
public class CollegeRole {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "role", nullable = false, unique = true)
    private String role;

    @Column(name = "authorities", nullable = false)
    private long[] authorityIds;

    @ManyToMany(mappedBy = "userRoles")
    private Set<CollegeUser> users = new HashSet<>();
}
