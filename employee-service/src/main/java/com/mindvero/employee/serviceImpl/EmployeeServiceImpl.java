package com.mindvero.employee.serviceImpl;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.mindvero.employee.dto.APIResponseDto;
import com.mindvero.employee.dto.DepartmentDto;
import com.mindvero.employee.dto.EmployeeDto;
import com.mindvero.employee.entity.Employee;
import com.mindvero.employee.mapper.EmployeeMapper;
import com.mindvero.employee.repository.EmployeeRepository;
import com.mindvero.employee.service.APIClient;
import com.mindvero.employee.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;
	//private RestTemplate restTemplate;
	//private WebClient webClient;
	private APIClient apiClient;
	public EmployeeServiceImpl(EmployeeRepository employeeRepository,
							  /*RestTemplate restTemplate
								WebClient webClient*/
								APIClient apiClient) {
		this.employeeRepository = employeeRepository;
		// this.restTemplate = restTemplate;
		// this.webClient = webClient;
		this.apiClient = apiClient;
	}

	@Override
	public EmployeeDto saveEmployee(EmployeeDto dto) {
		Employee employee = EmployeeMapper.mapToEntity(dto);
		Employee saveEmployee = employeeRepository.save(employee);
		return EmployeeMapper.mapToDto(saveEmployee);
	}

	@Override
	public APIResponseDto getEmployeeByID(Long id) {
		Employee employee = employeeRepository.findById(id)
						  .orElseThrow(() -> new RuntimeException
								  ("Employee is not found with given ID"));
		
		/*
		 * ResponseEntity<DepartmentDto> responseEntity =
		 * restTemplate.getForEntity("http://localhost:8080/department/api/"+employee.
		 * getDepartmentCode(), DepartmentDto.class);
		 * 
		 * DepartmentDto departmentDto = responseEntity.getBody();
		 */
		
		/*
		 * DepartmentDto departmentDto = webClient.get()
		 * .uri("http://localhost:8080/department/api/"+employee.getDepartmentCode())
		 * .retrieve() .bodyToMono(DepartmentDto.class) .block();
		 */
		
		DepartmentDto departmentDto = apiClient.getDepartmentByCode(employee.getDepartmentCode());
		EmployeeDto employeeDto = EmployeeMapper.mapToDto(employee);
		
		APIResponseDto apiResponseDto = new APIResponseDto();
		apiResponseDto.setDepartment(departmentDto);
		apiResponseDto.setEmployee(employeeDto);
		
		return apiResponseDto;
	}

}
