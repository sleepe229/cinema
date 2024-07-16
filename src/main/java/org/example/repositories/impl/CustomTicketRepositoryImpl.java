package org.example.repositories.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.example.entities.Cinema;
import org.example.entities.SessionFilm;
import org.example.entities.Ticket;
import org.example.repositories.CustomTicketRepository;
import org.example.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public class CustomTicketRepositoryImpl implements CustomTicketRepository {

    @PersistenceContext
    private EntityManager entityManager;

    private final TicketRepository ticketRepository;

    @Autowired
    public CustomTicketRepositoryImpl(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @Override
    @Transactional
    public void addTicket(Ticket ticket) {
        entityManager.persist(ticket);
    }

    @Override
    public List<Ticket> findAllByCinemaAndSessionFilm(Cinema cinema, SessionFilm sessionFilm) {
        return ticketRepository.findAllByCinemaAndSessionFilm(cinema, sessionFilm);
    }

    @Override
    public Optional<Ticket> findById(int id) {
        return ticketRepository.findById(id);
    }

    @Override
    @Transactional
    public void updateTicketStatus(int id, String status, LocalDateTime lastTimeChangeStatus) {
        ticketRepository.updateTicketStatus(id, status, lastTimeChangeStatus);
    }

    @Override
    public List<Ticket> findAllLockedTicketsExpired(LocalDateTime currentTime) {
        return ticketRepository.findAllLockedTicketsExpired(currentTime);
    }
}
