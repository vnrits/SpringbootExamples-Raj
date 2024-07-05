package com.beyondkareers.winnerdetails.Repository;

import com.beyondkareers.winnerdetails.Model.Parent;
import com.beyondkareers.winnerdetails.Model.User;
import com.beyondkareers.winnerdetails.Model.WinnerDetails;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ParentRepository extends JpaRepository<Parent, Long> {
	
//	@Query("SELECT wd FROM WinnerDetails wd LEFT JOIN FETCH wd.images")
//    List<WinnerDetails> findAllWithImages();

//	@Query(value="select * from parent ",nativeQuery=true)
//	public List<Map> getAllUsers();
//	
//	@Query(value="select * from child where user_id=?1",nativeQuery=true)
//	public List<Map> getAllUserKids(Long userid);
	
	//@Query(value = "SELECT p.*, c.* FROM parents p LEFT JOIN children c ON p.id = c.parent_id", nativeQuery = true) 
	
	// or this 
	
	@Query("SELECT p, c FROM Parent p LEFT JOIN p.children c")
	List<Parent> findAllParentsWithChildren();
	
}
