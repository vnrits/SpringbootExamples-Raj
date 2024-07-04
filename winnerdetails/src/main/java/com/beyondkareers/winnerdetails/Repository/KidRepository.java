package com.beyondkareers.winnerdetails.Repository;

import com.beyondkareers.winnerdetails.Model.Kid;
import com.beyondkareers.winnerdetails.Model.WinnerDetails;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface KidRepository extends JpaRepository<Kid, Long> {
	
//	@Query("SELECT wd FROM WinnerDetails wd LEFT JOIN FETCH wd.images")
//    List<WinnerDetails> findAllWithImages();

	@Query(value = "select * from kid where user_id=?1", nativeQuery = true)
	public List<Map> getKidByUserId(Long userId);
	
}
