package com.eazybytes.cards.service.impl;

import com.eazybytes.cards.dto.CardsDto;
import com.eazybytes.cards.entity.Card;
import com.eazybytes.cards.repository.CardsServiceRepository;
import com.eazybytes.cards.service.ICardsService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardsServiceImpl implements ICardsService {
    @Autowired
    CardsServiceRepository cardsServiceRepository;

    @Override
    @Transactional
    public CardsDto createCard(CardsDto cardsDto) {
        Card card = new Card();
        card.setCardNumber(cardsDto.getCardNumber());
        card.setName(cardsDto.getName());
        card.setExpiryDate(cardsDto.getExpiryDate());
        card.setSecurityCode(cardsDto.getSecurityCode());
        cardsServiceRepository.save(card);
        return cardsDto;
    }
}
