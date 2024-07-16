package org.example.repositories.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.example.entities.Ticket;
import org.example.entities.User;
import org.example.repositories.CustomUserRepository;

import java.util.List;

public class CustomUserRepositoryImpl implements CustomUserRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public List<Ticket> findTicketByUser(User User) {
        return null;
    }

}
