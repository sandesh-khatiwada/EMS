package com.sandesh.ems.controller;

import com.sandesh.ems.dto.EmployeeDto;
import com.sandesh.ems.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class EmployeeController {

    EmployeeService employeeService;

    @PostMapping("/employee")

    public ResponseEntity<EmployeeDto> createEmployee( @RequestBody  EmployeeDto employeeDto){
        EmployeeDto response = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<EmployeeDto> findEmployeeById(@PathVariable Long id){
        EmployeeDto response = employeeService.findEmployeeById(id);
        return ResponseEntity.ok(response);

    }

    @GetMapping("/employees")
    public ResponseEntity<List<EmployeeDto>> findEmployees(){
        List<EmployeeDto> response = employeeService.findEmployees();
        return ResponseEntity.ok(response);
    }


}
