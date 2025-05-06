package com.sandesh.ems.service;

import com.sandesh.ems.dto.EmployeeDto;
import com.sandesh.ems.entity.Employee;
import com.sandesh.ems.exception.ResourceNotFoundException;
import com.sandesh.ems.mapper.EmployeeMapper;
import com.sandesh.ems.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{

    EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto findEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(()->new ResourceNotFoundException("Employee with the provided id does not exist"));

        return EmployeeMapper.mapToEmployeeDto(employee);

    }

    @Override
    public List<EmployeeDto> findEmployees() {
        List<Employee> employees = employeeRepository.findAll();

        return employees.stream().map((EmployeeMapper::mapToEmployeeDto)).collect(Collectors.toList());
    }
}
