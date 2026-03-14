package com.microservices.passenger.feign;

public class RentalCarDetailsDTO {

    private Long id;
    private String carModel;
    private String carNumber;
    private String carType;
    private Double rentPerDay;
    private String availability;

    // ── Constructors ──────────────────────────────────────────
    public RentalCarDetailsDTO() {}

    public RentalCarDetailsDTO(Long id, String carModel, String carNumber,
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
        return "RentalCarDetailsDTO{id=" + id + ", carModel='" + carModel + "', carNumber='" + carNumber +
               "', carType='" + carType + "', rentPerDay=" + rentPerDay + ", availability='" + availability + "'}";
    }
}
