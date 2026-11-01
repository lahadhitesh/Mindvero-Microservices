package com.mindvero.department.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindvero.department.dto.DepartmentDto;
import com.mindvero.department.service.DepartmentService;

@RestController
@RequestMapping("/department/api")
public class DepartmentController {

	private DepartmentService departmentService;

	public DepartmentController(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	@PostMapping()
	public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto dto) {
		DepartmentDto serviceDto = departmentService.saveDepartment(dto);
		return new ResponseEntity<>(serviceDto, HttpStatus.CREATED);
	}

	@GetMapping("/{code}")
	public ResponseEntity<DepartmentDto> getDepartmentByCode(@PathVariable String code) {
		DepartmentDto serviceDto = departmentService.getDepartentBCode(code);
		return ResponseEntity.ok(serviceDto);
	}
}
