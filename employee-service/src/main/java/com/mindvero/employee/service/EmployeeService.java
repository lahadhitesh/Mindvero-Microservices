package com.mindvero.employee.service;

import com.mindvero.employee.dto.APIResponseDto;
import com.mindvero.employee.dto.EmployeeDto;

public interface EmployeeService {

	EmployeeDto saveEmployee(EmployeeDto dto);

	APIResponseDto getEmployeeByID(Long id);

}
