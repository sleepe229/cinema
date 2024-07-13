package org.example.repositories;

import org.example.entities.Cinema;
import org.example.entities.SessionFilm;
import org.example.entities.Ticket;

import java.util.List;

public interface CustomTicketRepository {
    void addTicket(Ticket ticket);

    List<Ticket> findAllByCinemaAndSessionFilm(Cinema cinema, SessionFilm sessionFilm);
}
