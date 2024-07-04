package com.beyondkareers.winnerdetails.Controller;

import com.beyondkareers.winnerdetails.Model.Kid;
import com.beyondkareers.winnerdetails.Model.User;
import com.beyondkareers.winnerdetails.Model.WinnerDetails;
import com.beyondkareers.winnerdetails.Services.KidServices;
import com.beyondkareers.winnerdetails.Services.UserServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Kids")
public class KidController {

    @Autowired
    private KidServices kidServices;
    
    @Autowired
    private UserServices userServices;

    @PostMapping("/addKid/{userID}")
    private Kid addKid(@RequestBody Kid kid, @PathVariable Long userID){
    	
        //  obj.setImgPath(winnerDetails.getImgPath());
    	
    	User user = userServices.getUserById(userID);
    	kid.setUser(user);
        return kidServices.AddKid(kid);
    }

    @GetMapping("/getAllKids")
    private List<Kid> getAllWinnerDetails(){
        return kidServices.findAll();
    }
    
    @GetMapping("/get-kids/{userId}")
	public List<Map> getKids(@PathVariable Long userId){
		return kidServices.getKidsByUserId(userId);
	}
    

    @DeleteMapping("/{id}")
    public void deleteKid(@PathVariable Long id) {
    	kidServices.deleteKid(id);
    }

    
}
