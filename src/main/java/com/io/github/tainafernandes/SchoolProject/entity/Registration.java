package com.io.github.tainafernandes.SchoolProject.entity;

import java.util.List;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table(name = "tb_registration")
public class Registration {

    private Boolean graduated;

    @OneToMany(mappedBy = "registration")
    private List<Student> student;

    @OneToMany(mappedBy = "registration")
    private List<Course> course;
}
