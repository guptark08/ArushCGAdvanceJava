package com.microservices.carrentals.repository;

import com.microservices.carrentals.entity.RentalCarDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RentalCarRepository extends JpaRepository<RentalCarDetails, Long> {
    List<RentalCarDetails> findByAvailability(String availability);
    List<RentalCarDetails> findByCarType(String carType);
}
