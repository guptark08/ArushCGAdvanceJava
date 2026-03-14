package com.microservices.passenger.service;

import com.microservices.passenger.entity.PassengerDetails;
import com.microservices.passenger.repository.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PassengerService {

    @Autowired
    private PassengerRepository passengerRepository;

    public List<PassengerDetails> getAllPassengers() {
        return passengerRepository.findAll();
    }

    public Optional<PassengerDetails> getPassengerById(Long id) {
        return passengerRepository.findById(id);
    }

    public Optional<PassengerDetails> getPassengerByEmail(String email) {
        return passengerRepository.findByEmail(email);
    }

    public PassengerDetails savePassenger(PassengerDetails passenger) {
        if (passengerRepository.existsByEmail(passenger.getEmail())) {
            throw new RuntimeException("Passenger with email already exists: " + passenger.getEmail());
        }
        return passengerRepository.save(passenger);
    }

    public PassengerDetails updatePassenger(Long id, PassengerDetails updatedPassenger) {
        return passengerRepository.findById(id).map(p -> {
            p.setName(updatedPassenger.getName());
            p.setEmail(updatedPassenger.getEmail());
            p.setPhone(updatedPassenger.getPhone());
            p.setAddress(updatedPassenger.getAddress());
            p.setLicenseNumber(updatedPassenger.getLicenseNumber());
            return passengerRepository.save(p);
        }).orElseThrow(() -> new RuntimeException("Passenger not found with id: " + id));
    }

    public void deletePassenger(Long id) {
        passengerRepository.deleteById(id);
    }
}
