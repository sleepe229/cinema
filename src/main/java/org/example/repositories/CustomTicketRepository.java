package org.example.repositories;

import org.example.entities.Ticket;
import org.example.entities.Cinema;
import org.example.entities.SessionFilm;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface CustomTicketRepository {
    void addTicket(Ticket ticket);
    List<Ticket> findAllByCinemaAndSessionFilm(Cinema cinema, SessionFilm sessionFilm);
    Optional<Ticket> findById(int id);
    void updateTicketStatus(int id, String status, LocalDateTime lastTimeChangeStatus);
    List<Ticket> findAllLockedTicketsExpired(LocalDateTime currentTime);
    void save(Ticket ticket);
}
