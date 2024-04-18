package com.easybytes.loans.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatusCode;

@AllArgsConstructor
@Data
public class ResponseDto  {
    private String statusCode;
    private String statusMessage;
}
