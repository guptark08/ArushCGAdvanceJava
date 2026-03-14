package com.microservices.carrentals.service;

import com.microservices.carrentals.entity.BookingDetails;
import com.microservices.carrentals.entity.RentalCarDetails;
import com.microservices.carrentals.repository.BookingRepository;
import com.microservices.carrentals.repository.RentalCarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private RentalCarRepository rentalCarRepository;

    public List<BookingDetails> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Optional<BookingDetails> getBookingById(Long id) {
        return bookingRepository.findById(id);
    }

    public List<BookingDetails> getBookingsByPassenger(Long passengerId) {
        return bookingRepository.findByPassengerId(passengerId);
    }

    public BookingDetails createBooking(BookingDetails booking) {
        RentalCarDetails car = rentalCarRepository.findById(booking.getCarId())
                .orElseThrow(() -> new RuntimeException("Car not found with id: " + booking.getCarId()));

        if (!"AVAILABLE".equalsIgnoreCase(car.getAvailability())) {
            throw new RuntimeException("Car is not available for booking");
        }

        if (booking.getBookingDate() == null) {
            booking.setBookingDate(LocalDate.now());
        }
        booking.setStatus("CONFIRMED");

        // Mark car as BOOKED
        car.setAvailability("BOOKED");
        rentalCarRepository.save(car);

        return bookingRepository.save(booking);
    }

    public BookingDetails cancelBooking(Long id) {
        return bookingRepository.findById(id).map(booking -> {
            booking.setStatus("CANCELLED");
            // Mark car back to AVAILABLE
            rentalCarRepository.findById(booking.getCarId()).ifPresent(car -> {
                car.setAvailability("AVAILABLE");
                rentalCarRepository.save(car);
            });
            return bookingRepository.save(booking);
        }).orElseThrow(() -> new RuntimeException("Booking not found with id: " + id));
    }

    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }
}
