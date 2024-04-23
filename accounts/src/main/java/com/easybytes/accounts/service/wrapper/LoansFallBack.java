package com.easybytes.accounts.service.wrapper;

import com.easybytes.accounts.dto.wrapper.LoansDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class LoansFallBack implements LoansApiWrapper{
    @Override
    public ResponseEntity<LoansDto> fetchLoan(String mobileNumber) {
        return null;
    }
}
