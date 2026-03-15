package com.microservices.carrentals.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "booking_details")
public class BookingDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Passenger ID is required")
    @Column(name = "passenger_id", nullable = false)
    private Long passengerId;

    @NotNull(message = "Car ID is required")
    @Column(name = "car_id", nullable = false)
    private Long carId;

    @Column(name = "booking_date")
    private LocalDate bookingDate;

    @Column(name = "return_date")
    private LocalDate returnDate;

    @Column(name = "status")
    private String status;

    // ── Constructors ──────────────────────────────────────────
    public BookingDetails() {}

    public BookingDetails(Long id, Long passengerId, Long carId,
                          LocalDate bookingDate, LocalDate returnDate, String status) {
        this.id = id;
        this.passengerId = passengerId;
        this.carId = carId;
        this.bookingDate = bookingDate;
        this.returnDate = returnDate;
        this.status = status;
    }

    // ── Getters ───────────────────────────────────────────────
    public Long getId() { return id; }
    public Long getPassengerId() { return passengerId; }
    public Long getCarId() { return carId; }
    public LocalDate getBookingDate() { return bookingDate; }
    public LocalDate getReturnDate() { return returnDate; }
    public String getStatus() { return status; }

    // ── Setters ───────────────────────────────────────────────
    public void setId(Long id) { this.id = id; }
    public void setPassengerId(Long passengerId) { this.passengerId = passengerId; }
    public void setCarId(Long carId) { this.carId = carId; }
    public void setBookingDate(LocalDate bookingDate) { this.bookingDate = bookingDate; }
    public void setReturnDate(LocalDate returnDate) { this.returnDate = returnDate; }
    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return "BookingDetails{id=" + id + ", passengerId=" + passengerId + ", carId=" + carId +
               ", bookingDate=" + bookingDate + ", returnDate=" + returnDate + ", status='" + status + "'}";
    }
}
