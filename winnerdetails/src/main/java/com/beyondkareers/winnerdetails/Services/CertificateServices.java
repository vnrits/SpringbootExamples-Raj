package com.beyondkareers.winnerdetails.Services;

import com.beyondkareers.winnerdetails.Model.Certificate;

import com.beyondkareers.winnerdetails.Repository.CertificateRepository;
import com.beyondkareers.winnerdetails.Repository.ImagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CertificateServices {

    @Autowired
    private CertificateRepository certificateRepository;

   
    public List<Certificate> getAllCertificates() {
        return certificateRepository.findAll();
    }

    public Certificate getCertificateById(Long id) {
        return certificateRepository.findById(id).orElse(null);
    }

    public Certificate saveCertificate(Certificate certificate) {
        return certificateRepository.save(certificate);
    }

    public void deleteCertificate(Long id) {
        certificateRepository.deleteById(id);
    }

}
