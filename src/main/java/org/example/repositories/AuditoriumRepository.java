package org.example.repositories;

import jakarta.transaction.Transactional;
import org.example.entities.Auditorium;
import org.example.entities.Cinema;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuditoriumRepository extends BaseRepository<Auditorium, Integer>{

}