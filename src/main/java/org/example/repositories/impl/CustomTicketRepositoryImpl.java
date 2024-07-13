package org.example.repositories.impl;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.example.entities.Cinema;
import org.example.entities.SessionFilm;
import org.example.entities.Ticket;
import org.example.repositories.CustomTicketRepository;

import java.util.List;

public class CustomTicketRepositoryImpl<T, Integer> implements CustomTicketRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void addTicket(Ticket ticket) {
        entityManager.persist(ticket);
    }

    @Override
    public List<Ticket> findAllByCinemaAndSessionFilm(Cinema cinema, SessionFilm sessionFilm) {
        String query = "SELECT t FROM Ticket t" +
                "JOIN t.session s" +
                "JOIN s.auditorium a" +
                "JOIN a.cinema c" +
                "WHERE c = :cinema AND s.film = :sessionFilm";
        return entityManager.createQuery(query, Ticket.class)
                .setParameter("cinema", cinema)
                .setParameter("sessionFilm", sessionFilm)
                .getResultList();
    }
}