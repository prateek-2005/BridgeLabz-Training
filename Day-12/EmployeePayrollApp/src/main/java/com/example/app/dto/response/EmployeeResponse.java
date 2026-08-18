package com.example.app.dto.response;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeResponse {

    private Long employeeId;

    private String firstName;

    private String lastName;

    private String email;

    private String phone;

    private String gender;

    private LocalDate dateOfBirth;

    private LocalDate joiningDate;

    private String designation;

    private Long departmentId;

    private String departmentName;

    private String employmentType;

    private String status;
}
