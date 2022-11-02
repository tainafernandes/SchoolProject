package com.io.github.tainafernandes.SchoolProject.controllers;

import com.io.github.tainafernandes.SchoolProject.dto.MatterDto;
import com.io.github.tainafernandes.SchoolProject.entity.Matter;
import com.io.github.tainafernandes.SchoolProject.services.MatterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/matter")
public class MatterController {

    private final MatterService service;

    @GetMapping(value = "{id}")
    public Optional<Matter> findById(@PathVariable Long id){
        return service.findById(id);
    }

    @GetMapping
    public List<Matter> findAll(){
        return service.findAll();
    }

    @PostMapping
    public ResponseEntity create(@RequestBody @Valid MatterDto matterDto){
        return ResponseEntity.ok(service.create(matterDto));
    }

    @PutMapping(value = "{id}")
    public ResponseEntity update (@PathVariable("id") Long id, @RequestBody @Valid MatterDto matterDto){
        return ResponseEntity.ok(service.update(matterDto, id));
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
