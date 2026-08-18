package com.example.app.service;

import com.example.app.dto.request.DepartmentRequest;
import com.example.app.dto.response.DepartmentResponse;
import java.util.List;

public interface DepartmentService {

	DepartmentResponse createDepartment(DepartmentRequest request);

	DepartmentResponse getDepartmentById(Long id);

	List<DepartmentResponse> getAllDepartments();

	DepartmentResponse updateDepartment(Long id, DepartmentRequest request);

	void deleteDepartment(Long id);
}