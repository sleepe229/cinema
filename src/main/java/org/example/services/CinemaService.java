package org.example.services;

import org.example.dto.CinemaDTO;
import org.example.entities.Cinema;

public interface CinemaService {
    Cinema addCinema(CinemaDTO cinema);
}
