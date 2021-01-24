package com.cucumber.controller;

import com.cucumber.dto.EmployeeDTO;
import com.cucumber.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/v1/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping(path = "/create",consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity create(@RequestBody EmployeeDTO employee, UriComponentsBuilder uriComponentsBuilder) {
        Long id = employeeService.create(employee);

        final URI uri = uriComponentsBuilder.path("/v1/employee/{id}")
                .build(id);

        return ResponseEntity.created(uri)
                .build();
    }

}