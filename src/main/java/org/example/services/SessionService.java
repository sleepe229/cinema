package org.example.services;

import jakarta.transaction.Transactional;
import org.example.dto.SessionFilmDTO;
import org.example.entities.SessionFilm;
import org.example.entities.User;

import java.time.LocalDateTime;

public interface SessionService {
    SessionFilm addSession(SessionFilmDTO sessionFilm);
    SessionFilm findByAuditoriumIdAndFilmIdAndSessionDate(int auditoriumId, int filmId, LocalDateTime sessionDate);

}
