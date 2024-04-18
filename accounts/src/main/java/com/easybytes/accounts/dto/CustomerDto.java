package com.easybytes.accounts.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class CustomerDto {
    @NotEmpty(message = "email cannot be empty")
    private String email;
    @NotEmpty(message = "name cannot be empty")
    private String name;
    @NotEmpty(message = "mobileNumber cannot be empty")
    private String mobileNumber;
}
