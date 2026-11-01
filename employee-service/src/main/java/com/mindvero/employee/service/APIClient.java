package com.mindvero.employee.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.mindvero.employee.dto.DepartmentDto;

@FeignClient(url = "http://localhost:8080/", value = "depatment-service")
public interface APIClient {
	@GetMapping("department/api/{code}")
	DepartmentDto getDepartmentByCode(@PathVariable String code);

}
