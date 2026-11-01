package com.mindvero.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindvero.employee.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
