package org.example.repositories.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.example.entities.Ticket;
import org.example.entities.User;
import org.example.repositories.CustomUserRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class CustomUserRepositoryImpl implements CustomUserRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public List<Ticket> findTicketByUser(User User) {
        return null;
    }

}
