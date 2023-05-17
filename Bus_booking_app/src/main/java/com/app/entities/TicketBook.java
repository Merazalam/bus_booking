package com.app.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "ticket_book")
public class TicketBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "bus_no")
    private String busNo;

    @Column(name = "departure_city")
    private String departureCity;

    @Column(name = "arrival_city")
    private String arrivalCity;

    @Column(name = "route")
    private String route;

    @Column(name = "price")
    private Double price;
    @Column(name = "passenger")
    @OneToMany(mappedBy = "ticketBook", cascade = CascadeType.ALL)
    private List<Passenger> passengers = new ArrayList<>();
}
