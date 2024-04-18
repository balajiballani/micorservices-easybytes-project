package com.easybytes.loans.service.impl;

import com.easybytes.loans.dto.LoanDto;
import com.easybytes.loans.entity.Loan;
import com.easybytes.loans.repository.LoanRepository;
import com.easybytes.loans.service.ILoansService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.easybytes.loans.mapper.LoanMapper.mapToLoanDto;

@Service
public class LoanServiceImpl implements ILoansService {
    @Autowired
    LoanRepository loanRepository;
    @Override
    public void createLoan(LoanDto loanRequestDto) {
        Loan l = mapToLoanDto(new Loan(),loanRequestDto);
        loanRepository.save(l);
    }

    @Override
    public LoanDto fetchByLoanNumber(String loanNumber) {
        return null;
    }
}
