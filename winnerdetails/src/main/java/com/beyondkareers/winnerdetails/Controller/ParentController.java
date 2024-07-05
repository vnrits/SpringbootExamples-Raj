package com.beyondkareers.winnerdetails.Controller;

import com.beyondkareers.winnerdetails.Model.Child;
import com.beyondkareers.winnerdetails.Model.Images;
import com.beyondkareers.winnerdetails.Model.Parent;
import com.beyondkareers.winnerdetails.Model.WinnerDetails;
import com.beyondkareers.winnerdetails.Services.ChildServices;
import com.beyondkareers.winnerdetails.Services.ImagesServices;
import com.beyondkareers.winnerdetails.Services.ParentServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


// Parents = child 

@RestController
@RequestMapping("/parents")
public class ParentController {

    @Autowired
    private ParentServices parentServices;

    
    @Autowired
    private ChildServices childServices;
    
    
    @PostMapping("/addparent")
    private Parent addParent(@RequestBody Parent user){
     
        return parentServices.AddParent(user);
    }

    @GetMapping("/getallparent")
    private List<Parent> getAllParentDetails(){
        return parentServices.findAll();
    }

    @PostMapping
    public ResponseEntity<Parent> createParent(@RequestBody String name) {
        Parent parent = parentServices.createParent(name);
        return ResponseEntity.ok(parent);
    }

    @PostMapping("/{parentId}/children")
    public ResponseEntity<Parent> addChildren(@PathVariable Long parentId, @RequestBody List<Child> children) {
        Parent parent = parentServices.addChildren(parentId, children);
        return ResponseEntity.ok(parent);
    }
   
    // this 
    @GetMapping("/parents/{parentId}/children") // For fetching children of a specific parent
    public ResponseEntity<List<Child>> getChildrenByParentId(@PathVariable Long parentId) {
        List<Child> children = childServices.getChildrenByParentId(parentId);
        if (children.isEmpty()) {
            return ResponseEntity.notFound().build(); // Return 404 Not Found if no children found
        }
        return ResponseEntity.ok(children);
    }

    
    
    @GetMapping("/parents") // For fetching all parents with children
    public ResponseEntity<List<Parent>> getAllParentsWithChildren() {
        List<Parent> parents = parentServices.getAllParentsWithChildren();
        return ResponseEntity.ok(parents);
    }
    
   
}
