package org.example.services.impl;

import org.example.entities.Cinema;
import org.example.entities.SessionFilm;
import org.example.entities.Ticket;
import org.example.entities.User;
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
    private final CustomTicketRepository cTicketRepository;

    @Autowired
    public TicketServiceImpl(TicketRepository ticketRepository, CustomTicketRepository cTicketRepository) {
        this.ticketRepository = ticketRepository;
        this.cTicketRepository = cTicketRepository;
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
        cTicketRepository.addTicket(ticket);
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

    @Override
    @Transactional
    public void discountTicket(User user, int ticketId, float cost){
        final double FULL_PRICE = 1.0;
        final double DISCOUNT_25 = 0.75;
        final double DISCOUNT_50 = 0.5;
        final double DISCOUNT_75 = 0.25;

        var listTicketsUser = ticketRepository.findAllTicketsByUserWithinDateRange(user, LocalDateTime.now().minusMonths(1),LocalDateTime.now());
        switch (listTicketsUser.size()){
            case 0 -> ticketRepository.updateTicketPrice(ticketId, cost * FULL_PRICE);
            case 1 -> ticketRepository.updateTicketPrice(ticketId, cost * DISCOUNT_25);
            case 2 -> ticketRepository.updateTicketPrice(ticketId, cost * DISCOUNT_50);
            default -> ticketRepository.updateTicketPrice(ticketId, cost * DISCOUNT_75);
        }
    }


}
