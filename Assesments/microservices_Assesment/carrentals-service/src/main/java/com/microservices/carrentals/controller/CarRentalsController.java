package com.microservices.carrentals.controller;

import com.microservices.carrentals.entity.BookingDetails;
import com.microservices.carrentals.entity.RentalCarDetails;
import com.microservices.carrentals.service.BookingService;
import com.microservices.carrentals.service.RentalCarService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@Tag(name = "CarRentals Service", description = "Endpoints for rental cars and bookings")
public class CarRentalsController {

    @Autowired
    private RentalCarService rentalCarService;

    @Autowired
    private BookingService bookingService;

    // ─────────────────────────────────────────────────────────────
    //  /rentalcardetails  endpoints
    // ─────────────────────────────────────────────────────────────

    @Operation(summary = "Get all rental cars")
    @GetMapping("/rentalcardetails")
    public ResponseEntity<List<RentalCarDetails>> getAllRentalCars() {
        return ResponseEntity.ok(rentalCarService.getAllCars());
    }

    @Operation(summary = "Get rental car by ID")
    @GetMapping("/rentalcardetails/{id}")
    public ResponseEntity<RentalCarDetails> getRentalCarById(@PathVariable Long id) {
        return rentalCarService.getCarById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Get only available cars")
    @GetMapping("/rentalcardetails/available")
    public ResponseEntity<List<RentalCarDetails>> getAvailableCars() {
        return ResponseEntity.ok(rentalCarService.getAvailableCars());
    }

    @Operation(summary = "Add a new rental car")
    @PostMapping("/rentalcardetails")
    public ResponseEntity<RentalCarDetails> addRentalCar(@Valid @RequestBody RentalCarDetails car) {
        return ResponseEntity.status(HttpStatus.CREATED).body(rentalCarService.saveCar(car));
    }

    @Operation(summary = "Update a rental car")
    @PutMapping("/rentalcardetails/{id}")
    public ResponseEntity<RentalCarDetails> updateRentalCar(@PathVariable Long id,
                                                             @Valid @RequestBody RentalCarDetails car) {
        return ResponseEntity.ok(rentalCarService.updateCar(id, car));
    }

    @Operation(summary = "Delete a rental car")
    @DeleteMapping("/rentalcardetails/{id}")
    public ResponseEntity<String> deleteRentalCar(@PathVariable Long id) {
        rentalCarService.deleteCar(id);
        return ResponseEntity.ok("Rental car deleted successfully");
    }

    // ─────────────────────────────────────────────────────────────
    //  /bookingdetails  endpoints
    // ─────────────────────────────────────────────────────────────

    @Operation(summary = "Get all bookings")
    @GetMapping("/bookingdetails")
    public ResponseEntity<List<BookingDetails>> getAllBookings() {
        return ResponseEntity.ok(bookingService.getAllBookings());
    }

    @Operation(summary = "Get booking by ID")
    @GetMapping("/bookingdetails/{id}")
    public ResponseEntity<BookingDetails> getBookingById(@PathVariable Long id) {
        return bookingService.getBookingById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Get bookings by passenger ID")
    @GetMapping("/bookingdetails/passenger/{passengerId}")
    public ResponseEntity<List<BookingDetails>> getBookingsByPassenger(@PathVariable Long passengerId) {
        return ResponseEntity.ok(bookingService.getBookingsByPassenger(passengerId));
    }

    @Operation(summary = "Create a new booking")
    @PostMapping("/bookingdetails")
    public ResponseEntity<BookingDetails> createBooking(@Valid @RequestBody BookingDetails booking) {
        return ResponseEntity.status(HttpStatus.CREATED).body(bookingService.createBooking(booking));
    }

    @Operation(summary = "Cancel a booking")
    @PutMapping("/bookingdetails/cancel/{id}")
    public ResponseEntity<BookingDetails> cancelBooking(@PathVariable Long id) {
        return ResponseEntity.ok(bookingService.cancelBooking(id));
    }

    @Operation(summary = "Delete a booking")
    @DeleteMapping("/bookingdetails/{id}")
    public ResponseEntity<String> deleteBooking(@PathVariable Long id) {
        bookingService.deleteBooking(id);
        return ResponseEntity.ok("Booking deleted successfully");
    }
}
