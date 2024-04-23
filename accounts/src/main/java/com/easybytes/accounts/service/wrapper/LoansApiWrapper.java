package com.easybytes.accounts.service.wrapper;

import com.easybytes.accounts.dto.wrapper.LoansDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "loans",fallback = LoansFallBack.class)
public interface LoansApiWrapper {
    @GetMapping(value = "/api/fetch")
    ResponseEntity<LoansDto> fetchLoan(@RequestParam String mobileNumber);
}
