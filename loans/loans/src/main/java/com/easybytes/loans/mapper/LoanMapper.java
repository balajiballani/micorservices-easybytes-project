package com.easybytes.loans.mapper;

import com.easybytes.loans.dto.LoanDto;
import com.easybytes.loans.entity.Loan;

import java.util.Random;

public class LoanMapper {
    public static Loan mapToLoanDto(Loan loan, LoanDto loanDto) {
        loan.setLoanNumber(loanNumber());
        loan.setLoanType(loanDto.getLoanType());
        loan.setTotalLoan(loanDto.getTotalLoan());
        loan.setMobileNumber(loanDto.getMobileNumber());
        loan.setAmountPaid(loanDto.getAmountPaid());
        loan.setOutStandingAmount(loanDto.getOutStandingAmount());
        return loan;
    }

    public static LoanDto mapToLoan(LoanDto loanDto, Loan loan) {
        loanDto.setLoanNumber(loan.getLoanNumber());
        loanDto.setLoanType(loan.getLoanType());
        loanDto.setTotalLoan(loan.getTotalLoan());
        loanDto.setMobileNumber(loan.getMobileNumber());
        loanDto.setAmountPaid(loan.getAmountPaid());
        loanDto.setOutStandingAmount(loan.getOutStandingAmount());
        return loanDto;
    }

    public static String loanNumber() {
        Random random = new Random();
        StringBuilder loanNumber = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            loanNumber.append(random.nextInt(10));
        }
        return loanNumber.toString();
    }
}
