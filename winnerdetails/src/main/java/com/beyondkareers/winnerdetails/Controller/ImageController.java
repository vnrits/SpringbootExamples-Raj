package com.beyondkareers.winnerdetails.Controller;

import com.beyondkareers.winnerdetails.Model.Images;
import com.beyondkareers.winnerdetails.Model.WinnerDetails;
import com.beyondkareers.winnerdetails.Services.ImagesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Images")
public class ImageController {

    @Autowired
    private ImagesServices imagesServices;

    @PostMapping("/addImage")
    private Images addImage(@RequestBody Images img){
        //  obj.setImgPath(winnerDetails.getImgPath());
        return imagesServices.AddImages(img);
    }

    @GetMapping("/getAllImages")
    private List<Images> getAllWinnerDetails(){
        return imagesServices.findAll();
    }

    @DeleteMapping("/{id}")
    public void deleteImage(@PathVariable Long id) {
    	imagesServices.deleteImage(id);
    }

    
}
