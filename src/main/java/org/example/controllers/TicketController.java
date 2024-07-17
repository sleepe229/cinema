package org.example.controllers;

import org.example.dto.TicketDTO;
import org.example.entities.Cinema;
import org.example.entities.SessionFilm;
import org.example.entities.Ticket;
import org.example.entities.User;
import org.example.services.TicketService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    private final TicketService ticketService;
    private final ModelMapper modelMapper;

    @Autowired
    public TicketController(TicketService ticketService, ModelMapper modelMapper) {
        this.ticketService = ticketService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<TicketDTO>> getAllTicketsByStatus(@PathVariable String status) {
        List<TicketDTO> tickets = ticketService.getAllTicketsByStatus(status);
        return ResponseEntity.ok(tickets);
    }

    @GetMapping("/cinema/{cinemaId}/session/{sessionId}")
    public ResponseEntity<List<TicketDTO>> getAllTicketsByCinemaAndSessionFilm(
            @PathVariable Integer cinemaId, @PathVariable Integer sessionId) {
        Cinema cinema = new Cinema(); // You should fetch the cinema entity by ID
        cinema.setId(cinemaId);
        SessionFilm sessionFilm = new SessionFilm(); // You should fetch the sessionFilm entity by ID
        sessionFilm.setId(sessionId);
        List<TicketDTO> tickets = ticketService.getAllTicketsByCinemaAndSessionFilm(cinema, sessionFilm);
        return ResponseEntity.ok(tickets);
    }

    @PostMapping
    public ResponseEntity<Void> addTicket(@RequestBody TicketDTO ticketDTO) {
        ticketService.addTicket(ticketDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/lock/{id}")
    public ResponseEntity<Void> lockTicket(@PathVariable int id) {
        boolean locked = ticketService.lockTicket(id);
        if (locked) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    @PutMapping("/unlock-expired")
    public ResponseEntity<Void> unlockExpiredTickets() {
        ticketService.unlockExpiredTickets();
        return ResponseEntity.ok().build();
    }

    @PutMapping("/buy/{id}")
    public ResponseEntity<Void> buyTicket(@PathVariable int id) {
        ticketService.buyTicket(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/discount")
    public ResponseEntity<Void> discountTicket(@RequestBody User user, @RequestParam int id, @RequestParam float cost) {
        ticketService.discountTicket(user, id, cost);
        return ResponseEntity.ok().build();
    }
}
