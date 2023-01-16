package com.microservicescourse.mscustomers.controllers;

import com.microservicescourse.mscustomers.dtos.CustomerDTO;
import com.microservicescourse.mscustomers.entities.Customer;
import com.microservicescourse.mscustomers.services.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(params="cpf")
    @ResponseStatus(HttpStatus.OK)
    public List<Customer> getByCpf(@RequestParam("cpf") String cpf){
        return customerService.getByCpf(cpf);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public URI save(@RequestBody CustomerDTO customerDTO){
        Customer customer = customerService.save(customerDTO);
        return ServletUriComponentsBuilder
                .fromCurrentRequest()
                .query("cpf={cpf}")
                .buildAndExpand(customer.getCpf())
                .toUri();
    }
}
