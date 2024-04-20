package com.eazybytes.cards.service;

import com.eazybytes.cards.dto.CardsDto;
import com.eazybytes.cards.entity.Card;

public interface  ICardsService {
     void createCard(CardsDto cardsDto);
     CardsDto fetchCard(String mobileNumber);
}
