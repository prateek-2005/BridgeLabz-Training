package com.example.app.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LabelRequest {

    @NotBlank(message = "Label name is required")
    private String name;
}
