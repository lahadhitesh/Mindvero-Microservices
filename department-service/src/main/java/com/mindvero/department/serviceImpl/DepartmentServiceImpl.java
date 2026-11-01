package com.mindvero.department.serviceImpl;

import org.springframework.stereotype.Service;

import com.mindvero.department.dto.DepartmentDto;
import com.mindvero.department.entity.Department;
import com.mindvero.department.mapper.DepartmentMapper;
import com.mindvero.department.repository.DepartmentRepository;
import com.mindvero.department.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	private DepartmentRepository departmentService;

	public DepartmentServiceImpl(DepartmentRepository departmentService) {
		this.departmentService = departmentService;
	}

	@Override
	public DepartmentDto saveDepartment(DepartmentDto dto) {
		Department department = DepartmentMapper.maptoEntity(dto);
		Department savedDepartment = departmentService.save(department);
		return DepartmentMapper.maptoDto(savedDepartment);
	}

	@Override
	public DepartmentDto getDepartentBCode(String deptCode) {
		Department dept = departmentService.findByDepartmentCode(deptCode);
		return DepartmentMapper.maptoDto(dept);
	}

}
