package com.beyondkareers.winnerdetails.Services;


import com.beyondkareers.winnerdetails.Model.Certificate;
import com.beyondkareers.winnerdetails.Model.Images;
import com.beyondkareers.winnerdetails.Model.Parent;
import com.beyondkareers.winnerdetails.Model.Child;
import com.beyondkareers.winnerdetails.Model.WinnerDetails;
import com.beyondkareers.winnerdetails.Repository.ImagesRepository;
import com.beyondkareers.winnerdetails.Repository.ParentRepository;
import com.beyondkareers.winnerdetails.Repository.ChildRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ChildServices {
    @Autowired
    private ChildRepository childRepository;

    @Autowired
    private ParentRepository parentRepository;

    
    public List<Child> findAll() {
        return childRepository.findAll();
    }

    public Child AddChild (Child image){

        return childRepository.save(image);
    }
    
    public Child getChildById(Long id) {
        return childRepository.findById(id).orElse(null);
    }
    
    public void deleteChild(Long id) {
    	childRepository.deleteById(id);
    }
    
    public List<Child> getChildrenByParentId(Long parentId) {
        return childRepository.findByParent_Id(parentId); // Use JPA repository method
    }
    
    public Child createChild(String name, Long parentId) {
        Parent parent = new Parent(); // Or use parentRepository.findById(parentId) if parent details are needed
        parent.setId(parentId);  // Set the parent ID for association
        Child child = new Child();
        child.setName(name);
        child.setParent(parent);
        return childRepository.save(child);
    }
  
    /*
    public Parent addChildren(Long parentId, List<Child> children) {
    	
    	//Long parentId = children getParentId();
    	//List<Child> parentOptional = childRepository.findByParentId(parentId);
    	
    	//Parent parent = ((Optional<Parent>) childRepository.findByParentId(parentId)).orElseThrow(() -> new ResourceNotFoundException("Parent not found with ID: " + parentId));
       
    	Parent parent = parentRepository.getById(parentId);
    	children.forEach(child -> child.setParent(parent));
        parent.getChildren().addAll(children);
        return childRepository.save(parent);
    }
    */
    
    
}
