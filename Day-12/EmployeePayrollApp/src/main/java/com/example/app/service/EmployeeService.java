package com.example.app.service;

import com.example.app.dto.request.EmployeeRequest;
import com.example.app.dto.response.EmployeeResponse;
import java.util.List;

public interface EmployeeService {

	EmployeeResponse createEmployee(EmployeeRequest request);

	EmployeeResponse getEmployeeById(Long id);

	List<EmployeeResponse> getAllEmployees();

	EmployeeResponse updateEmployee(Long id, EmployeeRequest request);

	void deleteEmployee(Long id);
}
