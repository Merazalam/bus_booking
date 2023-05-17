package com.app.controller;

import com.app.entities.Passenger;
import com.app.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/passenger")
public class PassengerController {

    @Autowired
    private PassengerService passengerService;


    //http://localhost:8080/api/passenger/save
    @PostMapping("/save")
    public ResponseEntity<Passenger> savePassenger(@RequestBody Passenger passenger){
        Passenger savePassenger = passengerService.savePassenger(passenger);
        return new ResponseEntity<>(savePassenger, HttpStatus.CREATED);
    }
}
