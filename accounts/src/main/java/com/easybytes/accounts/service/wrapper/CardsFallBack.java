package com.easybytes.accounts.service.wrapper;

import com.easybytes.accounts.dto.wrapper.CardsDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class CardsFallBack implements CardsApiWrapper {
    @Override
    public ResponseEntity<CardsDto> fetchCardDetails(String mobileNumber) {
        return null;
    }
}
