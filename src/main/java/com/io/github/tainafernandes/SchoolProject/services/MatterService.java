package com.io.github.tainafernandes.SchoolProject.services;

import com.io.github.tainafernandes.SchoolProject.dto.MatterDto;
import com.io.github.tainafernandes.SchoolProject.entity.Matter;
import com.io.github.tainafernandes.SchoolProject.repositories.MatterRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MatterService {

    private final ModelMapper mapper;

    private final MatterRepository repository;

    public Optional<Matter> findById(Long id){
        return repository.findById(id);
    }

    public List<Matter> findAll(){
        return repository.findAll();
    }

    public Object create(MatterDto matterDto) {
        return repository.save(mapper.map(matterDto, Matter.class));
    }

    public Object update(MatterDto matterDto, Long id) {
        Optional<Matter> matterOptional = repository.findById(id);

        if(!matterOptional.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Matter not found!");
        }

        return repository.save(mapper.map(matterDto, Matter.class));
    }


    public void delete(Long id) {
        Optional<Matter> matterOptional = repository.findById(id);
        matterOptional.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Matter does not exist"));
        repository.deleteById(id);
    }
}
