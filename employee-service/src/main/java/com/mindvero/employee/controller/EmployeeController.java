package com.mindvero.employee.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindvero.employee.dto.APIResponseDto;
import com.mindvero.employee.dto.EmployeeDto;
import com.mindvero.employee.service.EmployeeService;

@RestController
@RequestMapping("employee/api")
public class EmployeeController {

	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@PostMapping
	public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto dto) {
		EmployeeDto saveDto = employeeService.saveEmployee(dto);
		return new ResponseEntity<>(saveDto, HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<APIResponseDto> getEmployeeById(@PathVariable Long id) {
		APIResponseDto apiResponseDto = employeeService.getEmployeeByID(id);
		return ResponseEntity.ok(apiResponseDto);
	}
}