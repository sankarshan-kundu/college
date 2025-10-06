package com.sk.college.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "COLLEGE_AUTHORITIES")
@NoArgsConstructor
@Getter
@Setter
public class CollegeAuthority {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "authority", nullable = false, unique = true)
    private String authority;
}
