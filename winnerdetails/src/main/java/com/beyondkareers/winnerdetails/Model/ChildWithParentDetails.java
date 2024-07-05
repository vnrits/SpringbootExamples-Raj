package com.beyondkareers.winnerdetails.Model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter


public class ChildWithParentDetails {

    private Long childId;
    private String childName;

    private Long parentId;
    private String parentName; // Add other parent fields as needed

    // Getters and setters
}
