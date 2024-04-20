package com.easybytes.accounts.service.wrapper;

import org.springframework.cloud.openfeign.FeignClient;

//cards is the application name
@FeignClient("cards")
public interface CardsApiWrapper {


}
