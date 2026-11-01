package com.mindvero.department.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindvero.department.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

	Department findByDepartmentCode(String departmentCode);
}