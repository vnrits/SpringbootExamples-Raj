
package com.example.repository;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import com.example.model.Customer;

@Component
public class CustomerRepository {
  List<Customer> customerList = new ArrayList<Customer>();

  @PostConstruct
  public void init() {
   customerList.add(new Customer(1, "frank"));
   customerList.add(new Customer(2, "john"));
  }

  public List<Customer> getData() {
    return customerList;
  }
  
  public void saveCustomer(Customer c) {
	  customerList.add(c);
  }
}