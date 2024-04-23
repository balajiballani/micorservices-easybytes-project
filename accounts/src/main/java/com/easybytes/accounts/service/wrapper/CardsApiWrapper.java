package com.easybytes.accounts.service.wrapper;

import com.easybytes.accounts.dto.wrapper.CardsDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

//cards is the application name
@FeignClient(name = "cards",fallback = CardsFallBack.class)
public interface CardsApiWrapper {
    @GetMapping(value = "/api/fetch")
    ResponseEntity<CardsDto> fetchCardDetails(@RequestParam String mobileNumber);

}