package com.microservicescourse.mscustomers.infra.repositories;

import com.microservicescourse.mscustomers.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findByCpf(String cpf);
}
