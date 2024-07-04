package com.beyondkareers.winnerdetails.Services;


import com.beyondkareers.winnerdetails.Model.Certificate;
import com.beyondkareers.winnerdetails.Model.Images;
import com.beyondkareers.winnerdetails.Model.Kid;
import com.beyondkareers.winnerdetails.Model.WinnerDetails;
import com.beyondkareers.winnerdetails.Repository.ImagesRepository;
import com.beyondkareers.winnerdetails.Repository.KidRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class KidServices {
    @Autowired
    private KidRepository kidRepository;

    public List<Kid> findAll() {
        return kidRepository.findAll();
    }

    public Kid AddKid (Kid image){

        return kidRepository.save(image);
    }
    
    public Kid getKidById(Long id) {
        return kidRepository.findById(id).orElse(null);
    }
    
    public void deleteKid(Long id) {
    	kidRepository.deleteById(id);
    }
    
    public List<Map> getKidsByUserId(Long id) {
    	return kidRepository.getKidByUserId(id);
    }
    
}
