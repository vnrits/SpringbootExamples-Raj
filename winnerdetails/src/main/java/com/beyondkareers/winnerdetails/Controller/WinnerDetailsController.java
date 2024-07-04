package com.beyondkareers.winnerdetails.Controller;

import com.beyondkareers.winnerdetails.Model.Certificate;
import com.beyondkareers.winnerdetails.Model.Customer;
import com.beyondkareers.winnerdetails.Model.Images;
import com.beyondkareers.winnerdetails.Model.WinnerDetails;
import com.beyondkareers.winnerdetails.Repository.CertificateRepository;
import com.beyondkareers.winnerdetails.Repository.CustomerRepository;
import com.beyondkareers.winnerdetails.Repository.WinnerDetailsRepository;
import com.beyondkareers.winnerdetails.Services.ImagesServices;
import com.beyondkareers.winnerdetails.Services.WinnerDetailsService;

import dto.ImageDTO;
import dto.WinnerDetailDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/winners")
public class WinnerDetailsController {

   // @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private WinnerDetailsService winnerDetailsService;

    @Autowired
    private ImagesServices imagesServices;
    //  @Autowired
    //   private ImagesServices imageService;

    @Autowired
    private CertificateRepository certificateRepository;

    @Autowired
    private WinnerDetailsRepository winnerDetailsRepository;

    @PostMapping("/addwinner")
    public String addUser(Customer customer) {

        customerRepository.save(customer);
     //   model.addAttribute("customers", customerRepository.findAll());
        return "add-customer";

      //  return "index";
    }

    
// NOT WORKING this doesnt return proper values in response dont use it 
    @GetMapping("/get-winners")
    public List<WinnerDetails> getAllWinners() {
        return winnerDetailsService.getAllWinners();
    }

    
    @GetMapping("/{id}")
    public WinnerDetails getWinnerById(@PathVariable Long id) {
        return winnerDetailsService.getWinnerById(id);
    }
    
    //WORKING
    @GetMapping("/get-winner-image/{id}")
    public Optional<WinnerDetailDTO> getWinnerDetailWithImages(@PathVariable Long id) {
        return winnerDetailsService.getWinnerDetailWithImages(id).map(this::convertToDTO);
    }
    
    
    // WORKING
    @PostMapping("/createwinner")
    public WinnerDetails createWinner(@RequestBody WinnerDetails winnerDetails) {
        return winnerDetailsService.saveWinner(winnerDetails);
    }
    
    // WORKING 
    @PostMapping("/createwinner-img")
    public WinnerDetails createWinnerImg(@RequestBody WinnerDetails winnerDetails) {
        return winnerDetailsService.saveWinnerDetailImage(winnerDetails);
    }
    

    @DeleteMapping("/{id}")
    public void deleteWinner(@PathVariable Long id) {
        winnerDetailsService.deleteWinner(id);
    }

  
    private WinnerDetailDTO convertToDTO(WinnerDetails winnerDetail) {
        WinnerDetailDTO dto = new WinnerDetailDTO();
        dto.setName(winnerDetail.getName());
        dto.setCompetition(winnerDetail.getCompetition());
        dto.setImages(winnerDetail.getImages().stream().map(this::convertToDTO).collect(Collectors.toList()));
        return dto;
    }
    
    private ImageDTO convertToDTO(Images image) {
        ImageDTO dto = new ImageDTO();
        dto.setUrl(image.getUrl());
        dto.setTitle(image.getTitle());
        return dto;
    }

    // WORKING this returns proper structure
    @GetMapping("/get-allwinner-images")
    public List<WinnerDetailDTO> getAllWinnersImg() {
        return winnerDetailsService.getAllWinnersWithImages().stream()
            .map(this::convertToDTO)
            .collect(Collectors.toList());
    }

}


