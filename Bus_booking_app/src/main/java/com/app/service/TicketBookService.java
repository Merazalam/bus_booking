package com.app.service;

import com.app.entities.Passenger;
import com.app.entities.TicketBook;

public interface TicketBookService {
    TicketBook saveTicket(TicketBook ticketBook,long passengerId);
}
