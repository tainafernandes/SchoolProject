package com.io.github.tainafernandes.SchoolProject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateStudentDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer registry;
    @NotBlank(message = "Name field cannot be empty")
    private String name;
    @NotBlank(message = "CPF field cannot be empty")
    private String cpf;
    @NotBlank(message = "Email field cannot be empty")
    private String email;
}
