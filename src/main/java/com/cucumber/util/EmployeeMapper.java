package com.cucumber.util;

import com.cucumber.dto.EmployeeDTO;
import com.cucumber.dto.PhoneDTO;
import com.cucumber.entity.Employee;
import com.cucumber.entity.Phone;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    Employee toEmployeeEntity(EmployeeDTO employee);

    EmployeeDTO toEmployee(Employee employeeEntity);

    Phone toPhoneEntity(PhoneDTO phone);

    PhoneDTO toPhone(Phone phoneEntity);
}