package com.microservices.passenger.controller;

import com.microservices.passenger.entity.PassengerDetails;
import com.microservices.passenger.feign.CarRentalsClient;
import com.microservices.passenger.feign.RentalCarDetailsDTO;
import com.microservices.passenger.service.PassengerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@Tag(name = "Passenger Service", description = "Endpoints for passenger management and rental car access")
public class PassengerController {

    @Autowired
    private PassengerService passengerService;

    @Autowired
    private CarRentalsClient carRentalsClient;

    // ─────────────────────────────────────────────────────────────
    //  /passengerdetails  endpoints
    // ─────────────────────────────────────────────────────────────

    @Operation(summary = "Get all passengers")
    @GetMapping("/passengerdetails")
    public ResponseEntity<List<PassengerDetails>> getAllPassengers() {
        return ResponseEntity.ok(passengerService.getAllPassengers());
    }

    @Operation(summary = "Get passenger by ID")
    @GetMapping("/passengerdetails/{id}")
    public ResponseEntity<PassengerDetails> getPassengerById(@PathVariable Long id) {
        return passengerService.getPassengerById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Add a new passenger")
    @PostMapping("/passengerdetails")
    public ResponseEntity<PassengerDetails> addPassenger(@Valid @RequestBody PassengerDetails passenger) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(passengerService.savePassenger(passenger));
    }

    @Operation(summary = "Update a passenger")
    @PutMapping("/passengerdetails/{id}")
    public ResponseEntity<PassengerDetails> updatePassenger(@PathVariable Long id,
                                                             @Valid @RequestBody PassengerDetails passenger) {
        return ResponseEntity.ok(passengerService.updatePassenger(id, passenger));
    }

    @Operation(summary = "Delete a passenger")
    @DeleteMapping("/passengerdetails/{id}")
    public ResponseEntity<String> deletePassenger(@PathVariable Long id) {
        passengerService.deletePassenger(id);
        return ResponseEntity.ok("Passenger deleted successfully");
    }

    // ─────────────────────────────────────────────────────────────
    //  /rentalcardetails  — accessed via Feign from CarRentals Service
    // ─────────────────────────────────────────────────────────────

    @Operation(summary = "View all rental cars (fetched from carrentals-service via Feign)")
    @GetMapping("/rentalcardetails")
    public ResponseEntity<List<RentalCarDetailsDTO>> getRentalCarDetails() {
        return ResponseEntity.ok(carRentalsClient.getAllRentalCars());
    }

    @Operation(summary = "View only available rental cars (fetched from carrentals-service via Feign)")
    @GetMapping("/rentalcardetails/available")
    public ResponseEntity<List<RentalCarDetailsDTO>> getAvailableRentalCars() {
        return ResponseEntity.ok(carRentalsClient.getAvailableCars());
    }
}
