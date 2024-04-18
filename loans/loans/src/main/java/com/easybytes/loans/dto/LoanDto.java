package com.easybytes.loans.dto;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class LoanDto {
    @Schema(description = "mobile Number of the loan",example = "9491277098")
    @NotEmpty(message = "mobile number cannot be empty")
    private String mobileNumber;
    @NotEmpty
    @Schema(description = "loan type",example = "House,Car")
    private String loanType;
    @Schema(description = "totalLoan",example = "100")
    private Double totalLoan;
    @Schema(description = "amountPaid",example = "100")
    private Double amountPaid;
    @Schema(description = "outStandingAmount",example = "100")
    private Double outStandingAmount;


}
