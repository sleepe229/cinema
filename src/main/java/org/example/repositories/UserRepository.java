package org.example.repositories;

import org.example.entities.Ticket;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends BaseRepository<Ticket, Integer> {
    List<Ticket> findAllByStatus(String status);

}