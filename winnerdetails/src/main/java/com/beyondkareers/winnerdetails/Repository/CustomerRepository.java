
package com.beyondkareers.winnerdetails.Repository;

import com.beyondkareers.winnerdetails.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

//import javax.transaction.Transactional;
import java.util.List;


@Repository 
public interface CustomerRepository extends JpaRepository<Customer, Long > {
 
	@Query(value = "select * from customer where id=?1", nativeQuery = true)
	  public  Customer  getCustomerbyID(Long id);
	
	@Query(value = "select * from customer", nativeQuery = true)
	  public  List<Customer>  getAllCustomers();
	
	@Modifying
    @Transactional
	@Query(value = "delete from customer where id=?1", nativeQuery = true)
	  public  void  deleteOne(Long id);
	
}