package com.io.github.tainafernandes.SchoolProject.repositories;

import com.io.github.tainafernandes.SchoolProject.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
