package com.beyondkareers.winnerdetails.Model;

//import jakarta.persistence.*;
import lombok.Data;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;

//@Data
//@Setter
//@Getter
@Entity
@Table(name = "winnersdetails")
public class WinnerDetails {

	

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long winner_id;
	private String name;
    private String competition;


    @OneToMany(mappedBy = "winnerDetail", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Images> images;
    

    
    public Long getWinner_id() {
		return winner_id;
	}

	public void setWinner_id(Long winner_id) {
		this.winner_id = winner_id;
	}
	

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompetition() {
        return competition;
    }

    public void setCompetition(String competition) {
        this.competition = competition;
    }

    public List<Images> getImages() {
        return images;
    }

    public void setImages(List<Images> images) {
        this.images = images;
    }
    
   /*
    private String city;
    private String school;
    private Integer age;
    private Integer compyear;
    private String profilelink;
    private String sponsor;
    private String dynamicPage;
    private String description;
    private String title;
    private String status;
    private String month;
    private String imgPath;
    */
  
    /*
    @OneToMany(mappedBy = "winnerDetails", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Certificate> certificates;
    */


    //    public Images getImage() {
//        return image;
//    }
//
//    public void setImage(Images image) {
//        this.image = image;
//    }

}
