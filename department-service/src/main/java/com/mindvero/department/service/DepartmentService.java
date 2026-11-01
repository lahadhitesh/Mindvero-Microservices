package com.mindvero.department.service;

import com.mindvero.department.dto.DepartmentDto;

public interface DepartmentService {

	DepartmentDto saveDepartment(DepartmentDto dto);

	DepartmentDto getDepartentBCode(String deptCode);
}
