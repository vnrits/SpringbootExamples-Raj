package com.beyondkareers.winnerdetails.Services;


import com.beyondkareers.winnerdetails.Model.Certificate;
import com.beyondkareers.winnerdetails.Model.Images;
import com.beyondkareers.winnerdetails.Model.WinnerDetails;
import com.beyondkareers.winnerdetails.Repository.ImagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImagesServices {
    @Autowired
    private ImagesRepository imageRepository;

    public List<Images> findAll() {
        return imageRepository.findAll();
    }

    public Images AddImages (Images image){

        return imageRepository.save(image);
    }
    
    public Images getImagesById(Long id) {
        return imageRepository.findById(id).orElse(null);
    }
    
    public void deleteImage(Long id) {
    	imageRepository.deleteById(id);
    }
    
}
