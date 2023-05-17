package com.app.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "search_bus")
public class Search {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Bus number must not be empty")
    @Column(name = "bus_no")
    private String busNo;

    @NotEmpty(message = "Departure location must not be empty")
    @Column(name = "departure")
    private String departure;

    @NotEmpty(message = "Arrival location must not be empty")
    @Column(name = "arrival")
    private String arrival;


    @Column(name = "date_of_departure")
    private Date dateOfDeparture;


    @Min(value = 1, message = "Number of seats must be at least 1")
    @Column(name = "number_of_seats")
    private int numberOfSeats;

    @Column(name = "is_round_trip")
    private boolean isRoundTrip;



}
