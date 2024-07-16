package org.example.repositories;

import org.example.entities.Ticket;
import org.example.entities.Cinema;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CinemaRepository extends BaseRepository<Cinema, Integer>{
//    void addCinema(Cinema cinema);

}