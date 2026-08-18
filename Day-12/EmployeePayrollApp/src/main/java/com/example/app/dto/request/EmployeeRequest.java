package com.example.app.dto.request;

import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeRequest {

    @NotBlank(message = "First name is required")
    @Size(max = 50)
    private String firstName;

    @NotBlank(message = "Last name is required")
    @Size(max = 50)
    private String lastName;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @Pattern(
        regexp = "^[0-9]{10}$",
        message = "Phone number must contain 10 digits"
    )
    private String phone;

    private String gender;

    private LocalDate dateOfBirth;

    @NotNull(message = "Joining date is required")
    private LocalDate joiningDate;

    @NotBlank(message = "Designation is required")
    private String designation;

    @NotNull(message = "Department ID is required")
    private Long departmentId;

    @NotBlank(message = "Employment type is required")
    private String employmentType;

    @NotBlank(message = "Status is required")
    private String status;
}
