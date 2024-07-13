package org.example.repositories;

import org.example.entities.Cinema;
import org.example.entities.SessionFilm;
import org.example.entities.Ticket;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends BaseRepository<Ticket, Integer>, CustomTicketRepository {

    List<Ticket> findAllByStatus(String status);
    @Query("SELECT t FROM Ticket t " +
            "JOIN t.session s " +
            "JOIN s.auditorium a " +
            "JOIN a.cinema c " +
            "WHERE c = :cinema AND s.film = :sessionFilm")
    List<Ticket> findAllByCinemaAndSessionFilm(Cinema cinema, SessionFilm sessionFilm);
}
