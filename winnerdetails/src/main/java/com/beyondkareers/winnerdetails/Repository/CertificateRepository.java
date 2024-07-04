package com.beyondkareers.winnerdetails.Repository;

import com.beyondkareers.winnerdetails.Model.Certificate;
import com.beyondkareers.winnerdetails.Model.Images;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CertificateRepository extends JpaRepository<Certificate, Long> {

}
