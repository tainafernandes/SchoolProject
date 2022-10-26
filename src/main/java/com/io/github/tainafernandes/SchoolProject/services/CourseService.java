package com.io.github.tainafernandes.SchoolProject.services;

import com.io.github.tainafernandes.SchoolProject.dto.CourseDto;
import com.io.github.tainafernandes.SchoolProject.entity.Course;
import com.io.github.tainafernandes.SchoolProject.repositories.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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

    public Object create(CourseDto courseDto) {
        Course course = new Course();
        course.setName(courseDto.getName());
        return repository.save(course);
    }

    public Object update(CourseDto courseDto, Long id) {
        Optional<Course> courseOptional = repository.findById(id);

        if(!courseOptional.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Course not found!");
        }

        Course course = courseOptional.get();
        course.setName(courseDto.getName());

        return repository.save(course);
    }


    public void delete(Long id) {
        Optional<Course> courseOptional = repository.findById(id);
        courseOptional.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Course does not exist"));
        repository.deleteById(id);
    }
}
