package com.beyondkareers.winnerdetails.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


//import lombok.Data;


//@Data
//@Setter
//@Getter
@Entity
public class Images {




    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long image_id;
    
    private String url;
    private String title;

//    @ManyToOne
//    @JoinColumn(name = "winner_id")
//    private WinnerDetails winnerDetail;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "winner_detail_id")
    private WinnerDetails winnerDetail;
    

	public Long getImage_id() {
		return image_id;
	}

	public void setImage_id(Long image_id) {
		this.image_id = image_id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public WinnerDetails getWinnerDetail() {
		return winnerDetail;
	}

	public void setWinnerDetail(WinnerDetails winnerDetail) {
		this.winnerDetail = winnerDetail;
	}
    
    
    
    
}
