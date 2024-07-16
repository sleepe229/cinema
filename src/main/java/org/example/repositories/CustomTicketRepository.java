package org.example.repositories;

import jakarta.transaction.Transactional;
import org.example.entities.Cinema;
import org.example.entities.SessionFilm;
import org.example.entities.Ticket;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface CustomTicketRepository {

    @Transactional
    void addTicket(Ticket ticket);

    List<Ticket> findAllByCinemaAndSessionFilm(Cinema cinema, SessionFilm sessionFilm);

    Optional<Ticket> findById(int id);

    void updateTicketStatus(int id, String status, LocalDateTime lastTimeChangeStatus);

    List<Ticket> findAllLockedTicketsExpired(LocalDateTime currentTime);
}
