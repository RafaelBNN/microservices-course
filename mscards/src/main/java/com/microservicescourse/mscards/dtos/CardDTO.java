package com.microservicescourse.mscards.dtos;

import com.microservicescourse.mscards.entities.Card;
import com.microservicescourse.mscards.enums.CardBrand;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CardDTO {
    private String name;
    private CardBrand brand;
    private BigDecimal salary;
    private BigDecimal basicLimit;

    public Card toModel(){
        return new Card(name, brand, salary, basicLimit);
    }
}
