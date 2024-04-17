package com.easybytes.accounts.controller;
import com.easybytes.accounts.dto.AccountContactInfo;
import com.easybytes.accounts.dto.CustomerDto;
import com.easybytes.accounts.dto.ErrorResponseDto;
import com.easybytes.accounts.dto.ResponseDto;
import com.easybytes.accounts.service.ICustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Account API's", description = "To create,read,update,delete customer")
@RestController
@RequestMapping(path = "/api/account", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
@Validated

public class AccountController {
    private ICustomerService customerService;
    private  AccountContactInfo accountContactInfo;
    @Operation(summary = "create api for a customer")
    @PostMapping(value = "/create", produces = {MediaType.APPLICATION_JSON_VALUE})
    //Since the error response dto class is in global exception handler SWAGGER is not able to scan so we use
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
    public ResponseEntity<ResponseDto> createAccount(@RequestBody @Valid  CustomerDto customerDto) {
        customerService.createCustomer(customerDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto("201", "Account Created SuccessFully"));

    }
    @GetMapping("/fetch")
    public ResponseEntity<CustomerDto> fetchCustomer(@RequestParam String mobile){
        CustomerDto customerDto =  customerService.fetchCustomer(mobile);
        return ResponseEntity.status(HttpStatus.OK).body(customerDto);
    }
    @GetMapping("/fetchContactInfo")
    public ResponseEntity<AccountContactInfo> fetchCustomer(){
        return ResponseEntity.status(HttpStatus.OK).body(accountContactInfo);
    }
}
