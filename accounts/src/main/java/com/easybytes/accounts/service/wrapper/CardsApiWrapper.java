package com.easybytes.accounts.service.wrapper;

import com.easybytes.accounts.dto.wrapper.CardsDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;

//cards is the application name
@FeignClient("/api/cards")
public interface CardsApiWrapper {

    ResponseEntity<CardsDto> fetchCardDetails(String mobileNumber);

}