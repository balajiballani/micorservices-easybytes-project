package com.easybytes.loans.service.impl;

import com.easybytes.loans.dto.LoanDto;
import com.easybytes.loans.entity.Loan;
import com.easybytes.loans.exception.LoansException;
import com.easybytes.loans.repository.LoanRepository;
import com.easybytes.loans.service.ILoansService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.easybytes.loans.mapper.LoanMapper.mapToLoan;
import static com.easybytes.loans.mapper.LoanMapper.mapToLoanDto;

@Service
public class LoanServiceImpl implements ILoansService {
    @Autowired
    LoanRepository loanRepository;

    @Override
    public void createLoan(LoanDto loanRequestDto) {
        Optional<Loan> loan = loanRepository.findByMobileNumber(loanRequestDto.getMobileNumber());
        if (loan.isPresent()) {
            throw new LoansException("Loan is already present with the number " + loanRequestDto.getMobileNumber());
        }
        Loan l = mapToLoanDto(new Loan(), loanRequestDto);
        loanRepository.save(l);
    }

    @Override
    public LoanDto fetchByPhoneNumber(String mobileNumber) {
        Loan loan = loanRepository.findByMobileNumber(mobileNumber).orElseThrow(() -> new LoansException("Loan is not present with the number " + mobileNumber));
        return mapToLoan(new LoanDto(), loan);
    }
}
