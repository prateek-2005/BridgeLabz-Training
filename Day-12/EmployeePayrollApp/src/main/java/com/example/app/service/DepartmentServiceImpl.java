package com.example.app.service;

import com.example.app.dto.request.DepartmentRequest;
import com.example.app.dto.response.DepartmentResponse;
import com.example.app.entity.Department;
import com.example.app.exception.ResourceNotFoundException;
import com.example.app.repository.DepartmentRepository;
import com.example.app.service.DepartmentService;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class DepartmentServiceImpl implements DepartmentService {

	private final DepartmentRepository departmentRepository;

	@Override
	public DepartmentResponse createDepartment(DepartmentRequest request) {

		if (departmentRepository.existsByDepartmentName(request.getDepartmentName())) {

			throw new IllegalArgumentException("Department already exists with name: " + request.getDepartmentName());
		}

		Department department = Department.builder().departmentName(request.getDepartmentName())
				.description(request.getDescription()).build();

		Department savedDepartment = departmentRepository.save(department);

		return mapToResponse(savedDepartment);
	}

	@Override
	@Transactional(readOnly = true)
	public DepartmentResponse getDepartmentById(Long id) {

		Department department = departmentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Department", "id", id));

		return mapToResponse(department);
	}

	@Override
	@Transactional(readOnly = true)
	public List<DepartmentResponse> getAllDepartments() {

		return departmentRepository.findAll().stream().map(this::mapToResponse).toList();
	}

	@Override
	public DepartmentResponse updateDepartment(Long id, DepartmentRequest request) {

		Department department = departmentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Department", "id", id));

		department.setDepartmentName(request.getDepartmentName());

		department.setDescription(request.getDescription());

		Department updatedDepartment = departmentRepository.save(department);

		return mapToResponse(updatedDepartment);
	}

	@Override
	public void deleteDepartment(Long id) {

		if (!departmentRepository.existsById(id)) {

			throw new ResourceNotFoundException("Department", "id", id);
		}

		departmentRepository.deleteById(id);
	}

	private DepartmentResponse mapToResponse(Department department) {

		return DepartmentResponse.builder().departmentId(department.getDepartmentId())
				.departmentName(department.getDepartmentName()).description(department.getDescription()).build();
	}
}
