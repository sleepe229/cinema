package org.example.services.impl;

import org.example.dto.SessionFilmDTO;
import org.example.entities.SessionFilm;
import org.example.repositories.CustomSessionRepository;
import org.example.services.SessionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class SessionServiceImpl implements SessionService {

    private final CustomSessionRepository sessionRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public SessionServiceImpl(CustomSessionRepository sessionFilmRepository, ModelMapper modelMapper) {
        this.sessionRepository = sessionFilmRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    @Transactional
    public SessionFilm addSession(SessionFilmDTO sessionFilmDTO) {
        SessionFilm sessionFilm = modelMapper.map(sessionFilmDTO, SessionFilm.class);
        sessionRepository.save(sessionFilm);
        System.out.println("SessionFilm saved with ID: " + sessionFilm.getId());
        return sessionFilm;
    }
    @Override
    @Transactional
    public SessionFilm findByAuditoriumIdAndFilmIdAndSessionDate(int auditoriumId, int filmId, LocalDateTime sessionDate) {
        return sessionRepository.findByAuditoriumIdAndFilmIdAndSessionDate(auditoriumId, filmId, sessionDate);
    }
}
