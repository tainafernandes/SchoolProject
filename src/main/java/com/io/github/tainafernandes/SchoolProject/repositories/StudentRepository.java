package com.io.github.tainafernandes.SchoolProject.repositories;

import com.io.github.tainafernandes.SchoolProject.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
