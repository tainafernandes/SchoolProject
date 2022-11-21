package com.io.github.tainafernandes.SchoolProject.services;

import com.io.github.tainafernandes.SchoolProject.dto.CreateStudentDto;
import com.io.github.tainafernandes.SchoolProject.dto.UpdateStudentDto;
import com.io.github.tainafernandes.SchoolProject.entity.Student;
import com.io.github.tainafernandes.SchoolProject.repositories.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository repository;

    private final ModelMapper mapper;
    public Optional<Student> findById(Long id){
        return repository.findById(id);
    }

    public List<Student> findAll(){
        return repository.findAll();
    }

    public Student create(CreateStudentDto createDTO) {
        return repository.save(mapper.map(createDTO, Student.class));
    }

    public Object update(UpdateStudentDto updateDto, Long id) {
        Optional<Student> studentOptional = repository.findById(id);

        if(!studentOptional.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found!");
        }

        return repository.save(mapper.map(updateDto, Student.class));
    }

    public void delete(Long id) {
        Optional<Student> studentOptional = repository.findById(id);
        studentOptional.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Student does not exist"));
        repository.deleteById(id);
    }
}
