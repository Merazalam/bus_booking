package com.app.service.impl;

import com.app.entities.Passenger;
import com.app.repository.PassengerRepository;
import com.app.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PassengerServiceImpl implements PassengerService {

    @Autowired
    private PassengerRepository passengerRepository;
    @Override
    public Passenger savePassenger(Passenger passenger) {
        Passenger savedPassenger = passengerRepository.save(passenger);
        return savedPassenger;
    }
}
