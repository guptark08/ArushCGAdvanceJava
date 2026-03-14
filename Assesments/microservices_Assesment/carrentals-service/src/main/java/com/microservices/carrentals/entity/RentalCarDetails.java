package com.microservices.carrentals.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "rentalcar_details")
public class RentalCarDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Car model is required")
    @Column(name = "car_model", nullable = false)
    private String carModel;

    @NotBlank(message = "Car number is required")
    @Column(name = "car_number", nullable = false, unique = true)
    private String carNumber;

    @Column(name = "car_type")
    private String carType;

    @Column(name = "rent_per_day")
    private Double rentPerDay;

    @Column(name = "availability")
    private String availability;

    // ── Constructors ──────────────────────────────────────────
    public RentalCarDetails() {}

    public RentalCarDetails(Long id, String carModel, String carNumber,
                             String carType, Double rentPerDay, String availability) {
        this.id = id;
        this.carModel = carModel;
        this.carNumber = carNumber;
        this.carType = carType;
        this.rentPerDay = rentPerDay;
        this.availability = availability;
    }

    // ── Getters ───────────────────────────────────────────────
    public Long getId() { return id; }
    public String getCarModel() { return carModel; }
    public String getCarNumber() { return carNumber; }
    public String getCarType() { return carType; }
    public Double getRentPerDay() { return rentPerDay; }
    public String getAvailability() { return availability; }

    // ── Setters ───────────────────────────────────────────────
    public void setId(Long id) { this.id = id; }
    public void setCarModel(String carModel) { this.carModel = carModel; }
    public void setCarNumber(String carNumber) { this.carNumber = carNumber; }
    public void setCarType(String carType) { this.carType = carType; }
    public void setRentPerDay(Double rentPerDay) { this.rentPerDay = rentPerDay; }
    public void setAvailability(String availability) { this.availability = availability; }

    @Override
    public String toString() {
        return "RentalCarDetails{id=" + id + ", carModel='" + carModel + "', carNumber='" + carNumber +
               "', carType='" + carType + "', rentPerDay=" + rentPerDay + ", availability='" + availability + "'}";
    }
}
