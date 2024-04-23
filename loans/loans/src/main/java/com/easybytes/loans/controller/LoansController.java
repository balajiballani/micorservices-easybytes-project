package com.easybytes.loans.controller;

import com.easybytes.loans.dto.LoanDto;
import com.easybytes.loans.dto.LoansContactInfo;
import com.easybytes.loans.dto.ResponseDto;
import com.easybytes.loans.service.ILoansService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api")
@RestController
@Validated
@AllArgsConstructor
public class LoansController {

   private ILoansService loanService;

   private LoansContactInfo loansContactInfo;

    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDto> createLoan(@RequestBody @Valid LoanDto loanRequestDto) {
         loanService.createLoan(loanRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto("201", "Loan created SuccessFully"));
    }

    @GetMapping("/fetchContactInfo")
    public ResponseEntity<LoansContactInfo> fetchCustomer(){
        return ResponseEntity.status(HttpStatus.OK).body(loansContactInfo);
    }
    @GetMapping("/fetch")
    public ResponseEntity<LoanDto> fetchLoan(@RequestParam
                                                     @Pattern(regexp="(^$|[0-9]{10})",message = "Mobile number must be 10 digits")
                                                     String mobileNumber) {
        LoanDto cardsDto = loanService.fetchByPhoneNumber(mobileNumber);
        return ResponseEntity.status(HttpStatus.OK).body(cardsDto);
    }

}
