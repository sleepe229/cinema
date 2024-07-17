package org.example.controllers;

import org.example.dto.CinemaDTO;
import org.example.services.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CinemaController {

    private final CinemaService cinemaService;

    @Autowired
    public CinemaController(CinemaService cinemaService) {
        this.cinemaService = cinemaService;
    }

    @PostMapping("/add/cinema")
    public ResponseEntity<Void> addCinema(@RequestBody CinemaDTO cinemaDTO) {
        cinemaService.addCinema(cinemaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
