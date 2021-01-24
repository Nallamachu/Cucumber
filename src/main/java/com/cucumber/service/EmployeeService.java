package com.cucumber.service;

import com.cucumber.dto.EmployeeDTO;
import com.cucumber.entity.Employee;
import com.cucumber.repository.EmployeeRepository;
import com.cucumber.util.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@Service
@Validated
public class EmployeeService {

    @Autowired
    private EmployeeMapper mapper;

    @Autowired
    private EmployeeRepository repository;

    @Transactional
    @Validated
    public Long create(@Valid EmployeeDTO employeeDTO) {
        Employee employee = mapper.toEmployeeEntity(employeeDTO);
        repository.save(employee);
        return employee.getId();
    }
}