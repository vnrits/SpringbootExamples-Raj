package com.beyondkareers.winnerdetails.Repository;

import com.beyondkareers.winnerdetails.Model.Images;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImagesRepository extends JpaRepository<Images, Long> {
}
