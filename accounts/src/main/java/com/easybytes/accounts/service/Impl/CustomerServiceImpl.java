package com.easybytes.accounts.service.Impl;

import com.easybytes.accounts.dto.CustomerDto;
import com.easybytes.accounts.dto.wrapper.AccountDetailsDto;
import com.easybytes.accounts.entity.Customer;
import com.easybytes.accounts.exception.CustomerAlreadyPresentException;
import com.easybytes.accounts.exception.ResourceNotFoundException;
import com.easybytes.accounts.mapper.CustomerMapper;
import com.easybytes.accounts.repository.AccountRepository;
import com.easybytes.accounts.repository.CustomerRepository;
import com.easybytes.accounts.service.ICustomerService;
import com.easybytes.accounts.service.wrapper.CardsApiWrapper;
import com.easybytes.accounts.service.wrapper.LoansApiWrapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements ICustomerService {
    private AccountRepository accountRepository;
    private CustomerRepository customerRepository;

    private CardsApiWrapper cardsApiWrapper;
    private LoansApiWrapper loansApiWrapper;

    @Override
    public void createCustomer(CustomerDto customerDto) {
        Customer c = CustomerMapper.mapToCustomer(new Customer(), customerDto);
        Optional<Customer> customer = customerRepository.findByMobileNumber(customerDto.getMobileNumber());
        if (customer.isPresent()) {
            throw new CustomerAlreadyPresentException("Customer Already exists with the same mobile number " + customerDto.getMobileNumber());
        }
        customerRepository.save(c);

    }

    @Override
    public CustomerDto fetchCustomer(String mobile) {
        Customer c = customerRepository.findByMobileNumber(mobile).orElseThrow(
                ()->new ResourceNotFoundException("Customer","mobile number",mobile)
        );
        return CustomerMapper.mapToCustomerDto(c,new CustomerDto());
    }

    @Override
    public AccountDetailsDto getDetailsByNumber(String phoneNumber) {
        AccountDetailsDto accountDetailsDto = new AccountDetailsDto();
        accountDetailsDto.setCustomerDto(fetchCustomer(phoneNumber));
        accountDetailsDto.setLoansDto(loansApiWrapper.fetchLoan(phoneNumber).getBody());
        accountDetailsDto.setCardsDto(cardsApiWrapper.fetchCardDetails(phoneNumber).getBody());
        return accountDetailsDto;
    }

}
