package com.mindvero.department.mapper;

import com.mindvero.department.dto.DepartmentDto;
import com.mindvero.department.entity.Department;

public class DepartmentMapper {

	public static DepartmentDto maptoDto(Department department) {
		DepartmentDto departmentDto = new DepartmentDto(
										department.getId(),
										department.getDepartmentName(),
										department.getDepartmentDescription(),
										department.getDepartmentCode());
		return departmentDto;
	}
	
	
	public static Department maptoEntity(DepartmentDto dto) {
		Department department = new Department(
								dto.getId(),
								dto.getDepartmentName(),
								dto.getDepartmentDescription(),
								dto.getDepartmentCode());
		return department;
	}
}
