package com.microservicescourse.mscards.services;

import com.microservicescourse.mscards.dtos.CardDTO;
import com.microservicescourse.mscards.entities.Card;
import com.microservicescourse.mscards.infra.repositories.CardRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CardService {

    private CardRepository cardRepository;

    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public Card save(CardDTO cardDTO){
        Card card = cardDTO.toModel();
        return cardRepository.save(card);
    }

    public List<Card> getCardsBySalaryLTE(Long salary){
        return cardRepository.findBySalaryLessThanEqual(BigDecimal.valueOf(salary));
    }
}
