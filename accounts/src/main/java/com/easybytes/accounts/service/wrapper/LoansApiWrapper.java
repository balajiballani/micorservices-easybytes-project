package com.easybytes.accounts.service.wrapper;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("/api/loans")
public interface LoansApiWrapper {
}
