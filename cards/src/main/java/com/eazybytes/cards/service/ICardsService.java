package com.eazybytes.cards.service;

import com.eazybytes.cards.dto.CardsDto;
import com.eazybytes.cards.entity.Card;

public interface  ICardsService {
     CardsDto createCard(CardsDto cardsDto);
}
