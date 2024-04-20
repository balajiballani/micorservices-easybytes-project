package com.easybytes.loans.service;

import com.easybytes.loans.dto.LoanDto;


public interface ILoansService {
  void createLoan(LoanDto loanRequestDto);
  LoanDto fetchByPhoneNumber(String mobileNumber);
}
