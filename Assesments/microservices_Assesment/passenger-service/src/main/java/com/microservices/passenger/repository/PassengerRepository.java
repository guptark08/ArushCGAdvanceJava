package com.microservices.passenger.repository;

import com.microservices.passenger.entity.PassengerDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface PassengerRepository extends JpaRepository<PassengerDetails, Long> {
    Optional<PassengerDetails> findByEmail(String email);
    boolean existsByEmail(String email);
}
