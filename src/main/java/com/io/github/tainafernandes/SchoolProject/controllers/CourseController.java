package com.io.github.tainafernandes.SchoolProject.controllers;

import com.io.github.tainafernandes.SchoolProject.entity.Course;
import com.io.github.tainafernandes.SchoolProject.services.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/course")
public class CourseController {

    private final CourseService service;

    @GetMapping(value = "{id}")
    public Optional<Course> findById(@PathVariable Long id){
        return service.findById(id);
    }

    @GetMapping
    public List<Course> findAll(){
        return  service.findAll();
    }
}
