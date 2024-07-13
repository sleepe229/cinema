package org.example.repositories;

import org.example.entities.Cinema;
import org.example.entities.SessionFilm;
import org.example.entities.Ticket;
import org.example.entities.User;

import java.util.List;

public interface CustomUserRepository {
    void addUser(User user);

    List<Ticket> findTicketByUser(User User);
}