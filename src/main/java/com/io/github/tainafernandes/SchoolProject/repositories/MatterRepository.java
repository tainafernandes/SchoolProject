package com.io.github.tainafernandes.SchoolProject.repositories;

import com.io.github.tainafernandes.SchoolProject.entity.Matter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatterRepository extends JpaRepository <Matter, Long>{
}
