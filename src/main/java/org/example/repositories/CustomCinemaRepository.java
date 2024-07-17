package org.example.repositories;

import org.example.entities.Cinema;
import org.example.entities.User;
import org.springframework.transaction.annotation.Transactional;

public interface CustomCinemaRepository {
    @Transactional
    void addCinema(Cinema cinema);

    @Transactional
    void save(Cinema cinema);
}
