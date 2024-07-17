package org.example.repositories.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.example.dto.UserDTO;
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

    @Override
    @Transactional
    public boolean existsById(int id) {
        return entityManager.find(User.class, id) != null;
    }

    @Override
    @Transactional
    public void save(User user) {
        if (user.getId() != 0) {
            entityManager.merge(user);
        } else {
            addUser(user);
        }
    }
}
