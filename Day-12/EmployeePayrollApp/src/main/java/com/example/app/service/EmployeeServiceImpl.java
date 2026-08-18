package com.example.app.service;

import com.example.app.dto.request.EmployeeRequest;
import com.example.app.dto.response.EmployeeResponse;
import com.example.app.entity.Department;
import com.example.app.entity.Employee;
import com.example.app.exception.ResourceNotFoundException;
import com.example.app.repository.DepartmentRepository;
import com.example.app.repository.EmployeeRepository;
import com.example.app.service.EmployeeService;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;

    @Override
    public EmployeeResponse createEmployee(EmployeeRequest request) {

        if (employeeRepository.existsByEmail(request.getEmail())) {
            throw new IllegalArgumentException(
                    "Employee with email already exists"
            );
        }

        Department department = departmentRepository
                .findById(request.getDepartmentId())
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Department",
                                "id",
                                request.getDepartmentId()
                        )
                );

        Employee employee = Employee.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .phone(request.getPhone())
                .gender(request.getGender())
                .dateOfBirth(request.getDateOfBirth())
                .joiningDate(request.getJoiningDate())
                .designation(request.getDesignation())
                .department(department)
                .employmentType(request.getEmploymentType())
                .status(request.getStatus())
                .build();

        Employee savedEmployee = employeeRepository.save(employee);

        return mapToResponse(savedEmployee);
    }

    @Override
    @Transactional(readOnly = true)
    public EmployeeResponse getEmployeeById(Long id) {

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Employee",
                                "id",
                                id
                        )
                );

        return mapToResponse(employee);
    }

    @Override
    @Transactional(readOnly = true)
    public List<EmployeeResponse> getAllEmployees() {

        return employeeRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public EmployeeResponse updateEmployee(
            Long id,
            EmployeeRequest request
    ) {

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Employee",
                                "id",
                                id
                        )
                );

        Department department = departmentRepository
                .findById(request.getDepartmentId())
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Department",
                                "id",
                                request.getDepartmentId()
                        )
                );

        employee.setFirstName(request.getFirstName());
        employee.setLastName(request.getLastName());
        employee.setEmail(request.getEmail());
        employee.setPhone(request.getPhone());
        employee.setGender(request.getGender());
        employee.setDateOfBirth(request.getDateOfBirth());
        employee.setJoiningDate(request.getJoiningDate());
        employee.setDesignation(request.getDesignation());
        employee.setDepartment(department);
        employee.setEmploymentType(request.getEmploymentType());
        employee.setStatus(request.getStatus());

        Employee updatedEmployee = employeeRepository.save(employee);

        return mapToResponse(updatedEmployee);
    }

    @Override
    public void deleteEmployee(Long id) {

        if (!employeeRepository.existsById(id)) {
            throw new ResourceNotFoundException(
                    "Employee",
                    "id",
                    id
            );
        }

        employeeRepository.deleteById(id);
    }

    private EmployeeResponse mapToResponse(Employee employee) {

        return EmployeeResponse.builder()
                .employeeId(employee.getEmployeeId())
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .email(employee.getEmail())
                .phone(employee.getPhone())
                .gender(employee.getGender())
                .dateOfBirth(employee.getDateOfBirth())
                .joiningDate(employee.getJoiningDate())
                .designation(employee.getDesignation())
                .departmentId(
                        employee.getDepartment().getDepartmentId()
                )
                .departmentName(
                        employee.getDepartment().getDepartmentName()
                )
                .employmentType(employee.getEmploymentType())
                .status(employee.getStatus())
                .build();
    }
}
