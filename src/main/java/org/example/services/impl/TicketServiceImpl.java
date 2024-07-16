package org.example.services.impl;

import org.example.entities.Cinema;
import org.example.entities.SessionFilm;
import org.example.entities.Ticket;
import org.example.repositories.CustomTicketRepository;
import org.example.repositories.TicketRepository;
import org.example.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;

    @Autowired
    public TicketServiceImpl(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @Override
    public List<Ticket> getAllTicketsByStatus(String status) {
        return ticketRepository.findAllByStatus(status);
    }

    @Override
    public List<Ticket> getAllTicketsByCinemaAndSessionFilm(Cinema cinema, SessionFilm sessionFilm) {
        return ticketRepository.findAllByCinemaAndSessionFilm(cinema, sessionFilm);
    }

    @Override
    @Transactional
    public void addTicket(Ticket ticket) {
        ticketRepository.addTicket(ticket);
    }

    @Override
    @Transactional
    public boolean lockTicket(int ticketId) {
        Optional<Ticket> optionalTicket = ticketRepository.findById(ticketId);
        if (optionalTicket.isPresent()) {
            Ticket ticket = optionalTicket.get();
            if ("AVAILABLE".equals(ticket.getStatus())) {
                ticketRepository.updateTicketStatus(ticketId, "LOCKED", LocalDateTime.now());
                return true;
            }
        }
        return false;
    }

    @Override
    @Transactional
    public void unlockExpiredTickets() {
        List<Ticket> lockedTicketsExpired = ticketRepository.findAllLockedTicketsExpired(LocalDateTime.now().minusMinutes(15));
        lockedTicketsExpired.forEach(ticket -> ticketRepository.updateTicketStatus(ticket.getId(), "AVAILABLE", LocalDateTime.now()));
    }

    @Override
    @Transactional
    public void buyTicket(int ticketId) {
        Optional<Ticket> optionalTicket = ticketRepository.findById(ticketId);
        if (optionalTicket.isPresent()) {
            Ticket ticket = optionalTicket.get();
            if ("LOCKED".equals(ticket.getStatus())) {
                ticketRepository.updateTicketStatus(ticketId, "SOLD", LocalDateTime.now());
            }
        }
    }
}
