package com.sk.college.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "COLLEGE_AUTHORITIES")
@Getter
@Setter
public class CollegeAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "authority", nullable = false, unique = true)
    private String authority;

    @ManyToMany(mappedBy = "roleAuthorities")
    private Set<CollegeRole> roles;
}
