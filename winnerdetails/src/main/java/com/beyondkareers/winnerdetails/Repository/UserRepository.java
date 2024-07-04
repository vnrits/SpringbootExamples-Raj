package com.beyondkareers.winnerdetails.Repository;

import com.beyondkareers.winnerdetails.Model.User;
import com.beyondkareers.winnerdetails.Model.WinnerDetails;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
//	@Query("SELECT wd FROM WinnerDetails wd LEFT JOIN FETCH wd.images")
//    List<WinnerDetails> findAllWithImages();

	@Query(value="select * from user ",nativeQuery=true)
	public List<Map> getAllUsers();
	
	@Query(value="select * from kid where user_id=?1",nativeQuery=true)
	public List<Map> getAllUserKids(Long userid);
}
