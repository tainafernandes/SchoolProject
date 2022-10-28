package com.io.github.tainafernandes.SchoolProject.controllers;

import com.io.github.tainafernandes.SchoolProject.services.MatterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/matter")
public class MatterController {

    private final MatterService service;
}
