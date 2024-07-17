package org.example.repositories.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.example.dto.SessionFilmDTO;
import org.example.entities.Cinema;
import org.example.entities.SessionFilm;
import org.example.repositories.CustomSessionRepository;
import org.example.repositories.SessionFilmRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

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

    @Override
    @Transactional
    public void save(SessionFilm sessionFilm) {
        if (sessionFilm.getId() != 0) {
            entityManager.merge(sessionFilm);
        } else {
            addSession(sessionFilm);
        }
    }

    @Override
    public SessionFilm findByAuditoriumIdAndFilmIdAndSessionDate(int auditoriumId, int filmId, LocalDateTime sessionDate) {
        String jpql = "SELECT s FROM SessionFilm s WHERE s.auditorium.id = :auditoriumId AND s.film.id = :filmId AND s.sessionDate = :sessionDate";
        return entityManager.createQuery(jpql, SessionFilm.class)
                .setParameter("auditoriumId", auditoriumId)
                .setParameter("filmId", filmId)
                .setParameter("sessionDate", sessionDate)
                .getSingleResult();
    }

    @Override
    public void saveSessionFilm(SessionFilm sessionFilm) {
        if (sessionFilm.getId() != 0) {
            entityManager.merge(sessionFilm);
        } else {
            entityManager.persist(sessionFilm);
        }
    }
}
