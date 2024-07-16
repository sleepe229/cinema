package org.example.repositories.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.example.entities.Cinema;
import org.example.repositories.CustomCinemaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class CustomCinemaRepositoryImpl implements CustomCinemaRepository {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public void addCinema(Cinema cinema) {
        entityManager.persist(cinema);
    }
}
