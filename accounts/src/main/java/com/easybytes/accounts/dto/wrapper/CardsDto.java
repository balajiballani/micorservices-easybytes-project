package com.easybytes.accounts.dto.wrapper;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CardsDto {
    private String cardNumber;
    private String mobileNumber;
    private double totalLimit;
    private double amountUsed;
    private double availableAmount;
}
