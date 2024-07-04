package com.beyondkareers.winnerdetails.Services;


import com.beyondkareers.winnerdetails.Model.Certificate;
import com.beyondkareers.winnerdetails.Model.Images;
import com.beyondkareers.winnerdetails.Model.User;
import com.beyondkareers.winnerdetails.Model.WinnerDetails;
import com.beyondkareers.winnerdetails.Repository.ImagesRepository;
import com.beyondkareers.winnerdetails.Repository.KidRepository;
import com.beyondkareers.winnerdetails.Repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

@Service
public class UserServices {
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private KidRepository kidRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User AddUser (User user){

        return userRepository.save(user);
    }
    
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
    
    public void deleteUser(Long id) {
    	userRepository.deleteById(id);
    }
    
    
    public List<Map> findAllWithKids(){
    	List<Map> getUser = userRepository.getAllUsers();
  //  	System.out.println("Gana ++++++++++" + getUser.size());
    	
		JSONArray jsonArray = new JSONArray();
		
		for (int i = 0; i < getUser.size(); i++) {
			 Map map = getUser.get(i);
			 
			// System.out.println("Gana 111111 ::: " + i);
			 System.out.println("Gana" + i);
			 Long productId = (Long) map.get("user_id");
			 
			// System.out.println("Gana 22222::::" + i );
			 
		List<Map> kid = userRepository.getAllUserKids(productId);
		
			System.out.println("Gana 3333::::" + kid.size() );
		JSONObject eachObject = new JSONObject(getUser.get(i));
		 eachObject.put("kid", kid);
		 jsonArray.add(i, eachObject);
			
		
		}
		 return jsonArray;
    }
}
