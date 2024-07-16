package org.example.repositories.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.example.entities.SessionFilm;
import org.example.repositories.CustomSessionRepository;
import org.example.repositories.SessionFilmRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class CustomSessionRepositoryImpl implements CustomSessionRepository {

    @PersistenceContext
    private EntityManager entityManager;

    private final SessionFilmRepository sessionFilmRepository;

    public CustomSessionRepositoryImpl(SessionFilmRepository sessionFilmRepository) {
        this.sessionFilmRepository = sessionFilmRepository;
    }

    @Override
    @Transactional
    public void addSession(SessionFilm sessionFilm) {
        entityManager.persist(sessionFilm);
    }

}
