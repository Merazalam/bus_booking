package com.app.repository;

import com.app.entities.TicketBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketBookRepository extends JpaRepository<TicketBook,Long> {
}
