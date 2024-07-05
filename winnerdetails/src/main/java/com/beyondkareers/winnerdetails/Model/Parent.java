package com.beyondkareers.winnerdetails.Model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

//https://chatgpt.com/share/2f09bb54-07ec-4d1d-813e-11c08bcdec75

@Setter
@Getter
@Entity
public class Parent {
	
	
    
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id") // Ensure this matches the database schema
    private Long id;
	
    private String name;

   /// @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, orphanRemoval = true)
    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, fetch = FetchType.EAGER) // Eager fetching for children#
    @JsonManagedReference
    private List<Child> children;
    
    //private List<Child> children = new ArrayList<>();  // Initialize empty list


}
