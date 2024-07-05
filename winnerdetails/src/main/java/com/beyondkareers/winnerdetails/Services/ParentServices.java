package com.beyondkareers.winnerdetails.Services;


import com.beyondkareers.winnerdetails.Model.Certificate;
import com.beyondkareers.winnerdetails.Model.Child;
import com.beyondkareers.winnerdetails.Model.Images;
import com.beyondkareers.winnerdetails.Model.Parent;
import com.beyondkareers.winnerdetails.Model.WinnerDetails;
import com.beyondkareers.winnerdetails.Repository.ImagesRepository;
import com.beyondkareers.winnerdetails.Repository.KidRepository;
import com.beyondkareers.winnerdetails.Repository.ParentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

@Service
public class ParentServices {
    @Autowired
    private ParentRepository parentRepository;
    
    @Autowired
    private KidRepository kidRepository;

    public List<Parent> findAll() {
        return parentRepository.findAll();
    }

    public Parent AddParent (Parent parent){

        return parentRepository.save(parent);
    }
    
    
 

    public Parent createParent(String name) {
        Parent parent = new Parent();
        parent.setName(name);
        return parentRepository.save(parent);
    }

    public Parent addChildren(Long parentId, List<Child> children) {
        Parent parent = parentRepository.findById(parentId).orElseThrow(() -> new ResourceNotFoundException("Parent not found with ID: " + parentId));
        children.forEach(child -> child.setParent(parent)); // Set parent for each child
        parent.getChildren().addAll(children); // Add children to parent's list
        return parentRepository.save(parent);
    }
    
    	
    
    /*
    public List<Map> findAllWithKids(){
    	List<Map> getParent = parentRepository.getAllParents();
  //  	System.out.println("Gana ++++++++++" + getParent.size());
    	
		JSONArray jsonArray = new JSONArray();
		
		for (int i = 0; i < getParent.size(); i++) {
			 Map map = getParent.get(i);
			 
			// System.out.println("Gana 111111 ::: " + i);
			 System.out.println("Gana" + i);
			 Long productId = (Long) map.get("parent_id");
			 
			// System.out.println("Gana 22222::::" + i );
			 
		List<Map> kid = parentRepository.getAllParentKids(productId);
		
			System.out.println("Gana 3333::::" + kid.size() );
		JSONObject eachObject = new JSONObject(getParent.get(i));
		 eachObject.put("kid", kid);
		 jsonArray.add(i, eachObject);
			
		
		}
		 return jsonArray;
    }
    */
    
    public List<Parent> getAllParentsWithChildren() {
        return parentRepository.findAllParentsWithChildren(); // Implement custom query or use JPA fetching strategy
    }
}
