package com.beyondkareers.winnerdetails.Controller;

import com.beyondkareers.winnerdetails.Model.Images;
import com.beyondkareers.winnerdetails.Model.User;
import com.beyondkareers.winnerdetails.Model.WinnerDetails;
import com.beyondkareers.winnerdetails.Services.ImagesServices;
import com.beyondkareers.winnerdetails.Services.UserServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/User")
public class UserController {

    @Autowired
    private UserServices userServices;

    @PostMapping("/addUser")
    private User addUser(@RequestBody User user){
     
        return userServices.AddUser(user);
    }

    @GetMapping("/getAllUser")
    private List<User> getAllUserDetails(){
        return userServices.findAll();
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
    	userServices.deleteUser(id);
    }

    @GetMapping("/getAllUser-kids")
    private List<Map> getAllUserDetailsKids(){
        return userServices.findAllWithKids();
    }
}
