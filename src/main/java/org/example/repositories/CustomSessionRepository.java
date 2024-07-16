package org.example.repositories;

import jakarta.transaction.Transactional;
import org.example.entities.SessionFilm;
import org.example.services.SessionService;

public interface CustomSessionRepository {
    @Transactional
    void addSession(SessionFilm sessionFilm);
}
