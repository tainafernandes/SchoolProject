package com.io.github.tainafernandes.SchoolProject.controllers;

import com.io.github.tainafernandes.SchoolProject.dto.CourseDto;
import com.io.github.tainafernandes.SchoolProject.dto.CreateStudentDto;
import com.io.github.tainafernandes.SchoolProject.dto.UpdateStudentDto;
import com.io.github.tainafernandes.SchoolProject.entity.Course;
import com.io.github.tainafernandes.SchoolProject.services.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @PostMapping
    public ResponseEntity create(@RequestBody @Valid CourseDto courseDto){
        return ResponseEntity.ok(service.create(courseDto));
    }

    @PutMapping(value = "{id}")
    public ResponseEntity update (@RequestBody @Valid CourseDto courseDto){
        return ResponseEntity.ok(service.update(courseDto));
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
