package com.example.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.example.model.Customer;
import com.example.repository.CustomerRepository;

@RestController
public class CustomerController {
	@Autowired
	CustomerRepository repository;

	// working 
	@RequestMapping("/list")
	public List<Customer> findAll() {
		return repository.getAllCustomers();
	}

	@RequestMapping("/one/{id}")
	public Customer findOne(@PathVariable long id) {
		return repository.getCustomerbyID(id);
	}

	// Example with cURL_ curl -X POST http://localhost:8080/add -H 'Content-Type: application/json'   -d '{"id":"5","name":"Mark"}'
	
	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customer> create(@RequestBody Customer customer) {
		repository.save(customer);
		return new ResponseEntity<>(customer, HttpStatus.CREATED);
	}
}