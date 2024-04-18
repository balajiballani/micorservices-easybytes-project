package com.easybytes.loans.service;

import com.easybytes.loans.dto.LoanDto;


public interface ILoansService {
  void createLoan(LoanDto loanRequestDto);
  LoanDto fetchByLoanNumber(String loanNumber);
}
