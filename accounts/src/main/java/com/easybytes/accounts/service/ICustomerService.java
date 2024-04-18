package com.easybytes.accounts.service;
import com.easybytes.accounts.dto.CustomerDto;

public interface ICustomerService {
    void createCustomer(CustomerDto customerDto);
    CustomerDto fetchCustomer(String mobile);
}
