package com.easybytes.accounts.mapper;

import com.easybytes.accounts.dto.AccountDto;
import com.easybytes.accounts.entity.Account;

public class AccountMapper {
    public static AccountDto mapToAccountsDto(Account account, AccountDto accountDto){
        accountDto.setAccountId(account.getAccountId());
        accountDto.setAccountType(account.getAccountType());
        accountDto.setBranchAddress(account.getBranchAddress());
        return accountDto;
    }
    public static Account mapToAccount(Account account,AccountDto accountDto){
        account.setAccountId(accountDto.getAccountId());
        account.setAccountType(accountDto.getAccountType());
        account.setBranchAddress(accountDto.getBranchAddress());
        return account;
    }

}
