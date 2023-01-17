package com.microservicescourse.mscards.controllers;

import com.microservicescourse.mscards.dtos.CardDTO;
import com.microservicescourse.mscards.entities.Card;
import com.microservicescourse.mscards.services.CardService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cards")
public class CardController {

    private final CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping
    public String status(){
        return "ok";
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addCard(@RequestBody CardDTO cardDTO){
        cardService.save(cardDTO);
    }

    @GetMapping(params="salary")
    @ResponseStatus(HttpStatus.OK)
    public List<Card> getCardsSalaryLTE(@RequestParam("salary") Long salary){
        return cardService.getCardsBySalaryLTE(salary);
    }
}
