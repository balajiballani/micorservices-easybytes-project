package com.easybytes.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(name = "Account",description = "To send and receive account")
public class AccountDto {

    private Long accountId;


    private String accountType;

    private String branchAddress;
}
