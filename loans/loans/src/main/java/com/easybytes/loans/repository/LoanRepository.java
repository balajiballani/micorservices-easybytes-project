package com.easybytes.loans.repository;

import com.easybytes.loans.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoanRepository extends JpaRepository<Loan,Long> {
    Optional<Loan> findByMobileNumber(String mobileNumber);
}
