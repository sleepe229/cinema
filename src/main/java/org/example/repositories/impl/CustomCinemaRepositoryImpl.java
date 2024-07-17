package org.example.repositories.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.example.entities.Cinema;
import org.example.repositories.CustomCinemaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class CustomCinemaRepositoryImpl implements CustomCinemaRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void addCinema(Cinema cinema) {
        entityManager.persist(cinema);
        entityManager.flush();
        System.out.println("Cinema ID after persist: " + cinema.getId());
    }

    @Override
    @Transactional
    public void save(Cinema cinema) {
        if (cinema.getId() == 0) {
            addCinema(cinema);
        } else {
            entityManager.merge(cinema);

        }
    }
}
