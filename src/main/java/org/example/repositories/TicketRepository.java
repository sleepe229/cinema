package org.example.repositories;

import org.example.entities.Cinema;
import org.example.entities.SessionFilm;
import org.example.entities.Ticket;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface TicketRepository extends BaseRepository<Ticket, Integer> {

    List<Ticket> findAllByStatus(String status);

    @Query("SELECT t FROM Ticket t WHERE t.session.auditorium.cinema = :cinema AND t.session = :sessionFilm")
    List<Ticket> findAllByCinemaAndSessionFilm(@Param("cinema") Cinema cinema, @Param("sessionFilm") SessionFilm sessionFilm);


    @Query("SELECT t FROM Ticket t WHERE t.id = :id")
    Optional<Ticket> findById(@Param("id") int id);

    @Modifying
    @Query("UPDATE Ticket t SET t.status = :status, t.lastTimeChangeStatus = :lastTimeChangeStatus WHERE t.id = :id")
    void updateTicketStatus(@Param("id") int id, @Param("status") String status, @Param("lastTimeChangeStatus") LocalDateTime lastTimeChangeStatus);

    @Query("SELECT t FROM Ticket t WHERE t.status = 'LOCKED' AND t.lastTimeChangeStatus <= :currentTime")
    List<Ticket> findAllLockedTicketsExpired(@Param("currentTime") LocalDateTime currentTime);
}
