package com.io.github.tainafernandes.SchoolProject.services;

import com.io.github.tainafernandes.SchoolProject.entity.Course;
import com.io.github.tainafernandes.SchoolProject.entity.Student;
import com.io.github.tainafernandes.SchoolProject.repositories.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository repository;

    public Optional<Course> findById(Long id){
        return repository.findById(id);
    }

    public List<Course> findAll(){
        return repository.findAll();
    }
}
