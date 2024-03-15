package com.example.model.dto;

import jakarta.validation.constraints.NotBlank;

import java.math.BigInteger;

public record EmployeeRequest(@NotBlank String name, @NotBlank int age, @NotBlank BigInteger salary) {
}
