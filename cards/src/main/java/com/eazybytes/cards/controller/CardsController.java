package com.eazybytes.cards.controller;

import com.eazybytes.cards.dto.CardsContactInfo;
import com.eazybytes.cards.dto.CardsDto;
import com.eazybytes.cards.service.impl.CardsServiceImpl;
import jakarta.validation.Valid;
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
    CardsServiceImpl cardsService;

    @Autowired
    CardsContactInfo cardsContactInfo;

    @PostMapping("/create")
    public ResponseEntity<CardsDto> createCard(@RequestBody @Valid CardsDto card) {
        var cardsDto = cardsService.createCard(card);
        return ResponseEntity.status(HttpStatus.CREATED).body(cardsDto);
    }

    @GetMapping("/fetchContactInfo")
    public ResponseEntity<CardsContactInfo> fetchCustomer(){
        return ResponseEntity.status(HttpStatus.OK).body(cardsContactInfo);
    }

}