package com.eazybytes.cards.controller;

import com.eazybytes.cards.constants.CardsConstants;
import com.eazybytes.cards.dto.CardsContactInfo;
import com.eazybytes.cards.dto.CardsDto;
import com.eazybytes.cards.dto.ServiceResponseDto;
import com.eazybytes.cards.service.ICardsService;
import com.eazybytes.cards.service.impl.CardsServiceImpl;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/v1/cards")
@RestController
@Validated
public class CardsController {
    @Autowired
    ICardsService cardsService;

    @Autowired
    CardsContactInfo cardsContactInfo;

    @PostMapping("/create")
    public ResponseEntity<ServiceResponseDto> createCard(@RequestBody @Valid CardsDto card) {
          cardsService.createCard(card);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ServiceResponseDto(CardsConstants.MESSAGE_201,CardsConstants.STATUS_201));
    }
    @GetMapping("/fetch")
    public ResponseEntity<CardsDto> fetchCardDetails(@RequestParam
                                                     @Pattern(regexp="(^$|[0-9]{10})",message = "Mobile number must be 10 digits")
                                                     String mobileNumber) {
        CardsDto cardsDto = cardsService.fetchCard(mobileNumber);
        return ResponseEntity.status(HttpStatus.OK).body(cardsDto);
    }
    @GetMapping("/fetchContactInfo")
    public ResponseEntity<CardsContactInfo> fetchCustomer(){
        return ResponseEntity.status(HttpStatus.OK).body(cardsContactInfo);
    }

}