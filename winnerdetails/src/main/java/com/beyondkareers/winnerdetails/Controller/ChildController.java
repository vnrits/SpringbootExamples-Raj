package com.beyondkareers.winnerdetails.Controller;

import com.beyondkareers.winnerdetails.Model.Child;
import com.beyondkareers.winnerdetails.Model.Parent;
import com.beyondkareers.winnerdetails.Model.WinnerDetails;
import com.beyondkareers.winnerdetails.Services.ChildServices;
import com.beyondkareers.winnerdetails.Services.ParentServices;
import com.beyondkareers.winnerdetails.Services.ChildServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/child")
public class ChildController {

    @Autowired
    private ChildServices childServices;
    
    @Autowired
    private ParentServices  parentServices;

    
//    @PostMapping("/addChild/{userID}")
//    private Child addChild(@RequestBody Child child, @PathVariable Long userID){
//    	   
//   // 	Child child1 = parentServices.getChildById(userID);
//    //	child1.setChild_id(child);
//        return childServices.AddChild(child);
//    }

    @PostMapping("/{parentId}/children")
    public ResponseEntity<Child> addChild(@PathVariable Long parentId, @RequestBody String name) {
        Child child = childServices.createChild(name, parentId);
        return ResponseEntity.ok(child);
    }

    /*
    @PostMapping("/{parentId}/children")
    public ResponseEntity<Parent> addChildren(@PathVariable Long parentId, @RequestBody List<Child> children) {
        Parent parent = childServices.addChildren(parentId, children);
        return ResponseEntity.ok(parent);
    }
    */
    
}
