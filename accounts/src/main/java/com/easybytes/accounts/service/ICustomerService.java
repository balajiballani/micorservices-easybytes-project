package com.easybytes.accounts.service;
import com.easybytes.accounts.dto.CustomerDto;
import com.easybytes.accounts.dto.wrapper.AccountDetailsDto;

public interface ICustomerService {
    void createCustomer(CustomerDto customerDto);
    CustomerDto fetchCustomer(String mobile);

    AccountDetailsDto getDetailsByNumber(String phoneNumber);
}
