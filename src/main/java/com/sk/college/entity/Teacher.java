package com.sk.college.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "TEACHERS")
@Getter
@Setter
public class Teacher {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private CollegeUser user;

    @ManyToOne
    private Department department;
}
