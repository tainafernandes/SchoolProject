package com.io.github.tainafernandes.SchoolProject.repositories;

import com.io.github.tainafernandes.SchoolProject.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {

}
