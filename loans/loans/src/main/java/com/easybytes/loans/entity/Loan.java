package com.easybytes.loans.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Loan extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "native")
    @GenericGenerator(name = "native")
    private Long loanId;
    @Column(name = "mobile_number")
    private String mobileNumber;
    @Column(name = "loan_number")
    private String loanNumber;
    @Column(name = "loan_type")
    private String loanType;
    @Column(name = "total_loan")
    private Double totalLoan;
    @Column(name = "amount_paid")
    private Double amountPaid;
    @Column(name = "outstanding_amount")
    private Double outStandingAmount;
}
