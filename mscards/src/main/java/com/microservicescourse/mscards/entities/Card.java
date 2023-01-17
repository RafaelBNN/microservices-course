package com.microservicescourse.mscards.entities;

import com.microservicescourse.mscards.enums.CardBrand;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Card {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private CardBrand brand;
    private BigDecimal salary;
    private BigDecimal basicLimit;

    public Card(String name, CardBrand brand, BigDecimal salary, BigDecimal basicLimit) {
        this.name = name;
        this.brand = brand;
        this.salary = salary;
        this.basicLimit = basicLimit;
    }
}
