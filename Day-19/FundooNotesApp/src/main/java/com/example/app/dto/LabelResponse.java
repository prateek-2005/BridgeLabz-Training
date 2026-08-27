package com.example.app.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LabelResponse {

    private int labelId;

    private String name;
}
