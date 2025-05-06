package com.sandesh.ems.service;

import com.sandesh.ems.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {

    EmployeeDto createEmployee(EmployeeDto employeeDto);

    EmployeeDto findEmployeeById(Long employeeId);

    List<EmployeeDto> findEmployees();

    EmployeeDto updateEmployee(Long id, EmployeeDto updatedEmployee);

    void deleteEmployee(Long id);
}
