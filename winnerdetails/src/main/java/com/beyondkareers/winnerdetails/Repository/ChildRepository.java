package com.beyondkareers.winnerdetails.Repository;

import com.beyondkareers.winnerdetails.Model.Child;
import com.beyondkareers.winnerdetails.Model.ChildWithParentDetails;
import com.beyondkareers.winnerdetails.Model.Kid;
import com.beyondkareers.winnerdetails.Model.WinnerDetails;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ChildRepository extends JpaRepository<Child, Long> {
	
//	@Query("SELECT wd FROM WinnerDetails wd LEFT JOIN FETCH wd.images")
//    List<WinnerDetails> findAllWithImages();

//	@Query(value = "select * from child where user_id=?1", nativeQuery = true)
//	public List<Map> getKidByUserId(Long userId);
	
//	@Query("SELECT c FROM Child c WHERE c.parent.id = :parentId")
//	List<Child> findByParentId(@Param("parentId") Long parentId);
	
	@Query(value = "SELECT c.*, p.* FROM children c JOIN parents p ON c.parent_id = p.id", nativeQuery = true)
    List<ChildWithParentDetails> findAllWithParentDetails(); // Consider a dedicated response model if needed
	
	List<Child> findByParent_Id(Long parentId);
	
}
