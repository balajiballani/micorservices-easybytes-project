package com.easybytes.accounts.dto.wrapper;
import com.easybytes.accounts.dto.CustomerDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountDetailsDto {

    private CardsDto cardsDto;
    private LoansDto loansDto;
    private CustomerDto customerDto;
}
