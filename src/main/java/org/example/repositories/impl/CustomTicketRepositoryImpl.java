package org.example.repositories.impl;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.example.entities.Ticket;
import org.example.repositories.CustomTicketRepository;

public class CustomTicketRepositoryImpl<T, ID> implements CustomTicketRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void addTicket(Ticket ticket) {
        entityManager.persist(ticket);
    }
}