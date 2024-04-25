package com.easybytes.accounts.controller;

import com.easybytes.accounts.dto.AccountContactInfo;
import com.easybytes.accounts.dto.CustomerDto;
import com.easybytes.accounts.dto.ErrorResponseDto;
import com.easybytes.accounts.dto.ResponseDto;
import com.easybytes.accounts.dto.wrapper.AccountDetailsDto;
import com.easybytes.accounts.service.ICustomerService;
import io.github.resilience4j.retry.annotation.Retry;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;


@Tag(name = "Account API's", description = "To create,read,update,delete customer")
@RestController
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
@Validated
public class AccountController {
    private ICustomerService customerService;
    private AccountContactInfo accountContactInfo;

    private static final Logger logger = LoggerFactory.getLogger(AccountController.class);

    @Operation(summary = "create api for a customer")
    @PostMapping(value = "/create", produces = {MediaType.APPLICATION_JSON_VALUE})
    //Since the error response dto class is in global exception handler SWAGGER is not able to scan, so we use
    //content key in the @API response annotation
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP internal server error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    })
    public ResponseEntity<ResponseDto> createAccount(@RequestBody @Valid CustomerDto customerDto) {
        customerService.createCustomer(customerDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto("201", "Account Created SuccessFully"));

    }

    @GetMapping("/fetch")
    public ResponseEntity<CustomerDto> fetchCustomer(@RequestParam String mobile) {
        CustomerDto customerDto = customerService.fetchCustomer(mobile);
        return ResponseEntity.status(HttpStatus.OK).body(customerDto);
    }

    @Retry(name = "fetchCustomer", fallbackMethod = "fetchCustomerFallBack")
    @GetMapping("/fetchContactInfo")
    public ResponseEntity<AccountContactInfo> fetchCustomer() {
        logger.info("Account info main method");
        // throw new RuntimeException();
        return ResponseEntity.status(HttpStatus.OK).body(accountContactInfo);
    }

    /* fall back should be identical to the actual method but has an extra argument Throwable*/
    public ResponseEntity<AccountContactInfo> fetchCustomerFallBack(Throwable throwable) {
        AccountContactInfo accountContactInfo1 = new AccountContactInfo();
        accountContactInfo1.setContactDetails(new HashMap<>(Collections.emptyMap()));
        accountContactInfo1.setMessage("For Support contact escalation team");
        accountContactInfo1.setOnCallSupport(new ArrayList<>(Collections.singleton("9948112882")));
        logger.info("Account info fall back method");
        return ResponseEntity.status(HttpStatus.OK).body(accountContactInfo1);
    }

    @GetMapping("/fetchAccount")
    public ResponseEntity<AccountDetailsDto> fetchAccountDetails(@RequestParam String mobile) {
        AccountDetailsDto accountDetailsDto = customerService.getDetailsByNumber(mobile);
        return ResponseEntity.status(HttpStatus.OK).body(accountDetailsDto);
    }
}
