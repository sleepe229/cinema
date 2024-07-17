package org.example.repositories;

import jakarta.transaction.Transactional;
import org.example.entities.Seat;
import org.example.entities.SessionFilm;

public interface CustomSeatRepository {
    @Transactional
    void addSeat(Seat seat);
    @Transactional
    void save(Seat seat);
}
