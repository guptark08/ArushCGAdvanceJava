package com.microservices.carrentals.service;

import com.microservices.carrentals.entity.RentalCarDetails;
import com.microservices.carrentals.repository.RentalCarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class RentalCarService {

    @Autowired
    private RentalCarRepository rentalCarRepository;

    public List<RentalCarDetails> getAllCars() {
        return rentalCarRepository.findAll();
    }

    public Optional<RentalCarDetails> getCarById(Long id) {
        return rentalCarRepository.findById(id);
    }

    public List<RentalCarDetails> getAvailableCars() {
        return rentalCarRepository.findByAvailability("AVAILABLE");
    }

    public RentalCarDetails saveCar(RentalCarDetails car) {
        if (car.getAvailability() == null) {
            car.setAvailability("AVAILABLE");
        }
        return rentalCarRepository.save(car);
    }

    public RentalCarDetails updateCar(Long id, RentalCarDetails updatedCar) {
        return rentalCarRepository.findById(id).map(car -> {
            car.setCarModel(updatedCar.getCarModel());
            car.setCarNumber(updatedCar.getCarNumber());
            car.setCarType(updatedCar.getCarType());
            car.setRentPerDay(updatedCar.getRentPerDay());
            car.setAvailability(updatedCar.getAvailability());
            return rentalCarRepository.save(car);
        }).orElseThrow(() -> new RuntimeException("Car not found with id: " + id));
    }

    public void deleteCar(Long id) {
        rentalCarRepository.deleteById(id);
    }
}
