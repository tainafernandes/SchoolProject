package com.io.github.tainafernandes.SchoolProject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UpdateStudentDto {

    private Integer registry;
    @NotBlank(message = "Name field cannot be empty")
    private String name;
    @NotBlank(message = "Email field cannot be empty")
    private String email;
}
