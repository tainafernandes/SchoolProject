package com.io.github.tainafernandes.SchoolProject.controllers;

import com.io.github.tainafernandes.SchoolProject.dto.CreateStudentDto;
import com.io.github.tainafernandes.SchoolProject.dto.UpdateStudentDto;
import com.io.github.tainafernandes.SchoolProject.entity.Student;
import com.io.github.tainafernandes.SchoolProject.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {
    private final StudentService service;

    @GetMapping(value = "{id}")
    public Optional<Student> findById(@PathVariable Long id){
        return service.findById(id);
    }

    @GetMapping
    public List<Student> findAll(){
        return service.findAll();
    }

    @PostMapping
    public ResponseEntity create(@RequestBody @Valid CreateStudentDto createDTO){
        return ResponseEntity.ok(service.create(createDTO));
    }

    @PutMapping(value = "{id}")
    public ResponseEntity update (@RequestBody @Valid UpdateStudentDto updateDto){
        return ResponseEntity.ok(service.update(updateDto));
    }
}
