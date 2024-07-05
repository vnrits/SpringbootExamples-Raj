package com.beyondkareers.winnerdetails.Model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;


//https://chatgpt.com/share/2f09bb54-07ec-4d1d-813e-11c08bcdec75

@Setter
@Getter
@Entity
public class Child {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "child_id") // Ensure this matches the database schema
    private Long id;
	
    private String name;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "parent_id")
    private Parent parent;
	
	
}
