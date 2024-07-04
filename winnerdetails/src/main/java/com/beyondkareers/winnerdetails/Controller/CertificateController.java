package com.beyondkareers.winnerdetails.Controller;

import com.beyondkareers.winnerdetails.Model.Certificate;
import com.beyondkareers.winnerdetails.Model.Images;
import com.beyondkareers.winnerdetails.Model.WinnerDetails;
import com.beyondkareers.winnerdetails.Repository.WinnerDetailsRepository;
import com.beyondkareers.winnerdetails.Services.CertificateServices;
import com.beyondkareers.winnerdetails.Services.ImagesServices;
import com.beyondkareers.winnerdetails.Services.WinnerDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/certificates")
public class CertificateController {

    @Autowired
    private CertificateServices certificateService;

    @Autowired
    private WinnerDetailsService winnerDetailsService;

    @Autowired
    private WinnerDetailsRepository winnerDetailsRepository;

    @GetMapping
    public List<Certificate> getAllCertificates() {
        return certificateService.getAllCertificates();
    }

    @GetMapping("/{id}")
    public Certificate getCertificateById(@PathVariable Long id) {
        return certificateService.getCertificateById(id);
    }

    @PostMapping
    public Certificate createCertificate(@RequestBody Certificate certificate) {
        return certificateService.saveCertificate(certificate);
    }

    @DeleteMapping("/{id}")
    public void deleteCertificate(@PathVariable Long id) {
        certificateService.deleteCertificate(id);
    }


    @PostMapping("add-certificate/{userId}")
    public Certificate createWinnerID(@RequestBody Certificate certificate, @PathVariable Long userId) {
    	
    	WinnerDetails userObj = winnerDetailsService.getWinnerById(userId);
    	certificate.setWinnerDetails(userObj);
        return certificateService.saveCertificate(certificate);
    }
    
}
