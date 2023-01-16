package com.microservicescourse.mscustomers.services;

import com.microservicescourse.mscustomers.dtos.CustomerDTO;
import com.microservicescourse.mscustomers.entities.Customer;
import com.microservicescourse.mscustomers.infra.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer save(CustomerDTO customerDTO) {
        Customer customer = customerDTO.toModel();
        return customerRepository.save(customer);
    }

    public List<Customer> getByCpf(String cpf) {
        return customerRepository.findByCpf(cpf);
    }
}
