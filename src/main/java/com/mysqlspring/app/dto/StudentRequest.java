package com.mysqlspring.app.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class StudentRequest {
    @NotNull(message = "name should not be null")
    private String name;

    @Email(message = "invalid email address")
    private String email;

    @PositiveOrZero
    @Max(value = 65, message = "Age has to be less than 65")
    private Integer age;
}
