package org.example.repositories;

import jakarta.transaction.Transactional;
import org.example.entities.SessionFilm;
import org.example.services.SessionService;

import java.time.LocalDateTime;

public interface CustomSessionRepository {
    @Transactional
    void addSession(SessionFilm sessionFilm);
    @Transactional
    void save(SessionFilm sessionFilm);
    @Transactional
    SessionFilm findByAuditoriumIdAndFilmIdAndSessionDate(int auditoriumId, int filmId, LocalDateTime sessionDate);

}
