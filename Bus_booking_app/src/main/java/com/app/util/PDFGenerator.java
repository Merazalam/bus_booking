package com.app.util;

import com.app.entities.TicketBook;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class PDFGenerator {

    public static void generateTicketDetailsPDF(TicketBook ticketBook, String filePath) throws FileNotFoundException, DocumentException {
        // Create a new PDF document
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(filePath));
        document.open();

        // Add the Ticket Details header
        Paragraph header = new Paragraph("Ticket Details");
        header.setAlignment(Element.ALIGN_CENTER);
        document.add(header);

        // Create the Booked bus table
        PdfPTable table = new PdfPTable(6);
        table.setWidthPercentage(100);

        // Add table headers
        table.addCell("ID");
        table.addCell("Arrival City");
        table.addCell("Bus No");
        table.addCell("Departure City");
        table.addCell("Price");
        table.addCell("Route");

        // Add table rows with data
        table.addCell(ticketBook.getId().toString());
        table.addCell(ticketBook.getArrivalCity());
        table.addCell(ticketBook.getBusNo());
        table.addCell(ticketBook.getDepartureCity());
        table.addCell(ticketBook.getPrice().toString());
        table.addCell(ticketBook.getRoute());

        // Add the table to the document
        document.add(table);

        // Close the document
        document.close();
    }
}

