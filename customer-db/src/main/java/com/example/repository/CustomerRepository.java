
package com.example.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;


import com.example.model.Customer;


@Repository 
public interface CustomerRepository extends JpaRepository<Customer, Long > {
 
	@Query(value = "select * from customer where user_id=?1", nativeQuery = true)
	  public  Customer  getCustomerbyID(Long id);
	
	@Query(value = "select * from customer", nativeQuery = true)
	  public  List<Customer>  getAllCustomers();
	
	
	
}