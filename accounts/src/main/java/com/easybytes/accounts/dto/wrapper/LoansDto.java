package com.easybytes.accounts.dto.wrapper;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoansDto {

    private String mobileNumber;
    private String loanType;
    private Double totalLoan;
    private Double amountPaid;
    private Double outStandingAmount;
    private String loanNumber;
}
