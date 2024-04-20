package com.eazybytes.cards.service.impl;

import com.eazybytes.cards.constants.CardsConstants;
import com.eazybytes.cards.dto.CardsDto;
import com.eazybytes.cards.entity.Card;
import com.eazybytes.cards.exception.CardAlreadyExistsException;
import com.eazybytes.cards.exception.CardsNotFoundException;
import com.eazybytes.cards.mapper.CardsMapper;
import com.eazybytes.cards.repository.CardsServiceRepository;
import com.eazybytes.cards.service.ICardsService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class CardsServiceImpl implements ICardsService {
    @Autowired
    CardsServiceRepository cardsServiceRepository;

    @Override
    @Transactional
    public void createCard(CardsDto cardsDto) {
        Optional<Card> card = cardsServiceRepository.findByMobileNumber(cardsDto.getMobileNumber());
        if(card.isPresent()){
            throw new CardAlreadyExistsException("Card already registered with given mobileNumber "+cardsDto.getMobileNumber());
        }
        cardsServiceRepository.save(createNewCard(cardsDto.getMobileNumber()));
    }
    private Card createNewCard(String mobileNumber) {
        Card newCard = new Card();
        long randomCardNumber = 100000000000L + new Random().nextInt(900000000);
        newCard.setCardNumber(Long.toString(randomCardNumber));
        newCard.setMobileNumber(mobileNumber);
        newCard.setCardType(CardsConstants.CREDIT_CARD);
        newCard.setTotalLimit(CardsConstants.NEW_CARD_LIMIT);
        newCard.setAmountUsed(0);
        newCard.setAvailableAmount(CardsConstants.NEW_CARD_LIMIT);
        return newCard;
    }

    @Override
    public CardsDto fetchCard(String mobileNumber) {
        Card cards = cardsServiceRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new CardsNotFoundException("Card", "mobileNumber", mobileNumber)
        );
        return CardsMapper.mapToCardsDto(cards, new CardsDto());
    }
}
