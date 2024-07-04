package com.example.controller;

import com.example.model.Customer;
import com.example.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {
	@Autowired
	CustomerRepository repository;

	// working 
	@RequestMapping("/list")
	public List<Customer> findAll() {
		return repository.getAllCustomers();
	}
	
	// working 
		@RequestMapping("/listnative")
		public List<Customer> findAllNative() {
			return repository.findAll();
		}


	@GetMapping("/getNative/{id}")
	public Optional<Customer>  findOnevalue(@PathVariable long id) {
		//return repository.getCustomerbyID(id);
		return repository.findById(id);
		//return Optional.ofNullable(repository.getCustomerbyID(id));
	}

		
	@GetMapping("/getCustom/{id}")
	public Customer find(@PathVariable long id) {
		
		return repository.getCustomerbyID(id);
	}

	@DeleteMapping("/deleteNative/{id}")
	public ResponseEntity<String> deleteOnevalueN(@PathVariable long id) {
		
		 repository.deleteById(id);
		 return new ResponseEntity<>("Customer found", HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteCustom/{id}")
	public   ResponseEntity<String> deleteOneValueC(@PathVariable long id) {
		
		 repository.deleteOne(id);
		 return new ResponseEntity<>("Customer found", HttpStatus.OK);
	}
	
	
	// Example with cURL_ curl -X POST http://localhost:8080/add -H 'Content-Type: application/json'   -d '{"id":"5","name":"Mark"}'
	
	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customer> create(@RequestBody Customer customer) {
		repository.save(customer);
		return new ResponseEntity<>(customer, HttpStatus.CREATED);
	}
}