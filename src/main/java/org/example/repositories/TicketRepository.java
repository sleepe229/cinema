package org.example.repositories;

import org.example.entities.Ticket;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends BaseRepository<Ticket, Integer>, CustomTicketRepository {
    List<Ticket> findAllByStatus(String status);

}
