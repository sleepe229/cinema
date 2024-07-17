package org.example.controllers;

import org.example.dto.FilmDTO;
import org.example.entities.User;
import org.example.services.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/film")
public class FilmController {

    private final FilmService filmService;

    @Autowired
    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @PostMapping
    public ResponseEntity<Void> addFilm(@RequestBody FilmDTO filmDTO) {
        filmService.addFilm(filmDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/recommend")
    public ResponseEntity<List<FilmDTO>> recommendFilmsByUserGenres(@RequestBody User user) {
        List<FilmDTO> recommendedFilms = filmService.recommendFilmsByUserGenres(user);
        return ResponseEntity.ok(recommendedFilms);
    }
}
