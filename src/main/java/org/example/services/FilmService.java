package org.example.services;

import org.example.dto.FilmDTO;
import org.example.entities.Film;
import org.example.entities.User;

import java.util.List;

public interface FilmService {
    Film addFilm(FilmDTO film);
    List<FilmDTO> recommendFilmsByUserGenres(User user);
}
