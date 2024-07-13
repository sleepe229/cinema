package org.example.services.impl;

import org.example.entities.Cinema;
import org.example.entities.SessionFilm;
import org.example.entities.Ticket;
import org.example.repositories.TicketRepository;
import org.example.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

}
