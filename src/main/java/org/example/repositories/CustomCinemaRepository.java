package org.example.repositories;

import org.example.entities.Cinema;
import org.springframework.transaction.annotation.Transactional;

public interface CustomCinemaRepository {
    @Transactional
    void addCinema(Cinema cinema);
}
