package org.example.repositories;

import org.example.entities.Seat;
import org.example.entities.SessionFilm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatRepository extends BaseRepository <Seat, Integer> {
}
