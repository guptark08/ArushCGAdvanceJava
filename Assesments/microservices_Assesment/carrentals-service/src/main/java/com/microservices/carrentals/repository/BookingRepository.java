package com.microservices.carrentals.repository;

import com.microservices.carrentals.entity.BookingDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<BookingDetails, Long> {
    List<BookingDetails> findByPassengerId(Long passengerId);
    List<BookingDetails> findByCarId(Long carId);
    List<BookingDetails> findByStatus(String status);
}
