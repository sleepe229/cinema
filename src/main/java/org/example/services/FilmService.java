package org.example.services;

import org.example.entities.Film;
import org.example.entities.User;

import java.util.List;

public interface FilmService {
    void addFilm(Film film);
    List<Film> recommendFilmsByUserGenres(User user);
}
