package com.microservicescourse.mscards.infra.repositories;

import com.microservicescourse.mscards.entities.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface CardRepository extends JpaRepository<Card, Long> {

    List<Card> findBySalaryLessThanEqual(BigDecimal salary);
}
