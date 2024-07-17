package org.example.repositories;

import jakarta.transaction.Transactional;
import org.example.entities.Auditorium;
import org.example.entities.SessionFilm;

public interface CustomAuditoriumRepository {
    @Transactional
    void addAuditorium(Auditorium auditorium);

    @Transactional
    void save(Auditorium auditorium);
}
