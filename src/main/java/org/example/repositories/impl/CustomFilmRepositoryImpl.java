package org.example.repositories.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.example.entities.Film;
import org.example.repositories.CustomFilmRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Repository
public class CustomFilmRepositoryImpl implements CustomFilmRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void addFilm(Film film) {
        entityManager.persist(film);
    }
}
