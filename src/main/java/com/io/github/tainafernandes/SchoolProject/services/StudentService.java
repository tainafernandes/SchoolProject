package com.io.github.tainafernandes.SchoolProject.services;

import com.io.github.tainafernandes.SchoolProject.dto.CreateStudentDto;
import com.io.github.tainafernandes.SchoolProject.dto.UpdateStudentDto;
import com.io.github.tainafernandes.SchoolProject.entity.Student;
import com.io.github.tainafernandes.SchoolProject.repositories.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository repository;

    public Optional<Student> findById(Long id){
        return repository.findById(id);
    }

    public List<Student> findAll(){
        return repository.findAll();
    }

    public Student create(CreateStudentDto createDTO) {
        Student student = new Student();
        student.setRegistry(createDTO.getRegistry());
        student.setName(createDTO.getName());
        student.setCpf(createDTO.getCpf());
        student.setEmail(createDTO.getEmail());
        return repository.save(student);
    }

    public Student update(UpdateStudentDto updateDto) {

    }
}
