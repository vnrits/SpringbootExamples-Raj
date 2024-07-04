package com.beyondkareers.winnerdetails.Services;

import com.beyondkareers.winnerdetails.Model.Images;
import com.beyondkareers.winnerdetails.Model.WinnerDetails;
import com.beyondkareers.winnerdetails.Repository.WinnerDetailsRepository;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionalEventListener;

import com.beyondkareers.winnerdetails.Repository.ImagesRepository;


import java.util.List;
import java.util.Optional;
@Service
public class WinnerDetailsService {
    @Autowired
    private WinnerDetailsRepository winnerDetailsRepository;

    @Autowired
    private ImagesRepository imageRepository;

    public List<WinnerDetails> getAllWinners() {
        return winnerDetailsRepository.findAll();
    }

    public WinnerDetails getWinnerById(Long id) {
        return winnerDetailsRepository.findById(id).orElse(null);
    }

    public WinnerDetails saveWinner(WinnerDetails winnerDetails) {
        return winnerDetailsRepository.save(winnerDetails);
    }

    public void deleteWinner(Long id) {
        winnerDetailsRepository.deleteById(id);
    }
    
    @Transactional
    public WinnerDetails saveWinnerDetailImage(WinnerDetails winnerDetail) {
    
    	if (winnerDetail.getImages() != null) {
        for (Images image : winnerDetail.getImages()) {
            image.setWinnerDetail(winnerDetail);
        	}
    	}
       
    	
        return winnerDetailsRepository.save(winnerDetail);
    }

    public Optional<WinnerDetails> getWinnerDetailWithImages(Long id) {
        return winnerDetailsRepository.findById(id);
    }
    
    
    public List<WinnerDetails> getAllWinnersWithImages(){
    
    	return winnerDetailsRepository.findAll();
    }

    

    
   

}
