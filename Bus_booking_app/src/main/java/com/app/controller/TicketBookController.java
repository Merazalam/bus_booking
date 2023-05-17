package com.app.controller;

import com.app.entities.TicketBook;
import com.app.service.TicketBookService;
import com.app.util.PDFGenerator;
import com.itextpdf.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.io.FileNotFoundException;
import java.util.UUID;

@RestController
@RequestMapping("/api/ticketBook")
public class TicketBookController {

    @Autowired
    private TicketBookService ticketBookService;


    //http://localhost:8080/api/save/{passengerId}
    @PostMapping("/{passengerId}")
    @Transactional
    public ResponseEntity<TicketBook> saveTicket(@RequestBody TicketBook ticketBook, @PathVariable("passengerId")long passengerId) throws DocumentException, FileNotFoundException {
      TicketBook ticket =  ticketBookService.saveTicket(ticketBook,passengerId);

      // Generate PDF for the booked ticket with a unique file path
        String uniqueId = UUID.randomUUID().toString();
        String filePath = "G:\\Bus booking app\\Pdf generator\\" + uniqueId + ".pdf";
        PDFGenerator.generateTicketDetailsPDF(ticket, filePath);

        return new ResponseEntity<>(ticket, HttpStatus.CREATED);
    }
}
