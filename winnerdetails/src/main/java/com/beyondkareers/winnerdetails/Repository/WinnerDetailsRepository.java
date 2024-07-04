package com.beyondkareers.winnerdetails.Repository;

import com.beyondkareers.winnerdetails.Model.WinnerDetails;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface WinnerDetailsRepository extends JpaRepository<WinnerDetails, Long> {
	
//	@Query("SELECT wd FROM WinnerDetails wd LEFT JOIN FETCH wd.images")
//    List<WinnerDetails> findAllWithImages();

	
}
