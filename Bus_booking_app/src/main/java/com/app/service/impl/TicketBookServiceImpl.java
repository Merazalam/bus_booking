package com.app.service.impl;

import com.app.entities.Passenger;
import com.app.entities.TicketBook;
import com.app.exception.ResourceNotFoundException;
import com.app.repository.PassengerRepository;
import com.app.repository.TicketBookRepository;
import com.app.service.TicketBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TicketBookServiceImpl  implements TicketBookService {

    @Autowired
    private TicketBookRepository ticketBookRepository;
    @Autowired
  private  PassengerRepository passengerRepository;

    @Override

    public TicketBook saveTicket(TicketBook ticketBook, long passengerId) {
        Passenger passenger = passengerRepository.findById(passengerId).orElseThrow(
                () -> new ResourceNotFoundException("passenger", "id", passengerId)
        );
        passenger.setTicketBook(ticketBook);
        ticketBook.getPassengers().add(passenger);
        TicketBook bookedTicket = ticketBookRepository.save(ticketBook);

        return bookedTicket;
    }
}
