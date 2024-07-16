package org.example.services.impl;

import org.example.entities.SessionFilm;
import org.example.entities.User;
import org.example.repositories.CustomSessionRepository;
import org.example.services.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SessionServiceImpl implements SessionService {

    private final CustomSessionRepository sessionRepository;


    @Autowired
    public SessionServiceImpl(CustomSessionRepository sessionFilmRepository) {
        this.sessionRepository = sessionFilmRepository;
    }

    @Override
    @Transactional
    public void addSession(SessionFilm sessionFilm) {
        sessionRepository.addSession(sessionFilm);
    }

}
