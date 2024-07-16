package org.example.services;

import jakarta.transaction.Transactional;
import org.example.entities.SessionFilm;
import org.example.entities.User;

public interface SessionService {
    void addSession(SessionFilm sessionFilm);
}
