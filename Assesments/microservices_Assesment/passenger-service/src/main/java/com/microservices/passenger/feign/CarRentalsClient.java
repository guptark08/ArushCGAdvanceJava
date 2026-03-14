package com.microservices.passenger.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

/**
 * Feign client that calls carrentals-service via Eureka service name.
 * Passenger Service uses this to access /rentalcardetails from CarRentals Service.
 */
@FeignClient(name = "carrentals-service")
public interface CarRentalsClient {

    @GetMapping("/rentalcardetails")
    List<RentalCarDetailsDTO> getAllRentalCars();

    @GetMapping("/rentalcardetails/available")
    List<RentalCarDetailsDTO> getAvailableCars();
}
