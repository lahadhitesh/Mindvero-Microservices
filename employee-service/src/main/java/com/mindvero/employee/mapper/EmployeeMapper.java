package com.mindvero.employee.mapper;

import com.mindvero.employee.dto.EmployeeDto;
import com.mindvero.employee.entity.Employee;

public class EmployeeMapper {
	
	public static EmployeeDto mapToDto(Employee employee) {
		
		EmployeeDto dto = new EmployeeDto(
				employee.getId(),
				employee.getFirstName(),
				employee.getLastName(),
				employee.getEmail(),
				employee.getDepartmentCode());
		return dto;
	}
	
	public static Employee mapToEntity(EmployeeDto dto) {
		
		Employee employee = new Employee(
				dto.getId(),
				dto.getFirstName(),
				dto.getLastName(),
				dto.getEmail(),
				dto.getDepartmentCode());
		return employee;
	}

}
