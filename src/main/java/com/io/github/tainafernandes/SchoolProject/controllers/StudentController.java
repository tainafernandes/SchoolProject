package com.io.github.tainafernandes.SchoolProject.controllers;

import com.io.github.tainafernandes.SchoolProject.dto.CreateStudentDto;
import com.io.github.tainafernandes.SchoolProject.dto.UpdateStudentDto;
import com.io.github.tainafernandes.SchoolProject.entity.Student;
import com.io.github.tainafernandes.SchoolProject.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import org.modelmapper.ModelMapper;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {
    private final StudentService service;

    private final ModelMapper mapper;

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
    public ResponseEntity update (@PathVariable("id") Long id, @RequestBody @Valid UpdateStudentDto updateDto){
        return ResponseEntity.ok(mapper.map(updateDto, Student.class));
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
