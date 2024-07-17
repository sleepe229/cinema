package org.example.repositories;

import org.example.entities.Film;
import org.example.entities.SessionFilm;
import org.springframework.transaction.annotation.Transactional;

public interface CustomFilmRepository {
    @Transactional
    void addFilm(Film film);

    @Transactional
    void save(Film Film);
}
