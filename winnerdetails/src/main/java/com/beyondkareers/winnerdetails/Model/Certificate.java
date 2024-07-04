package com.beyondkareers.winnerdetails.Model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//@Data
@Setter
@Getter
@Entity
public class Certificate {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cert_id;
	
    private String title;
    private String path;
   
    /*
    @ManyToOne
    @JoinColumn(name = "winner_id")
    private WinnerDetails winnerDetails;
    */
    
   // @ManyToOne(fetch = FetchType.LAZY, optional = false)
   // @JoinColumn(name = "winner_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "winner_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private WinnerDetails winnerDetails;
    

}
