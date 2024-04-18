package com.eazybytes.cards.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class ServiceResponseDto {
    private String message;
    private HttpStatus statusCode;

}
