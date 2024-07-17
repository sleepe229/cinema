package org.example.repositories;

import org.example.dto.UserDTO;
import org.example.entities.Ticket;
import org.example.entities.User;

import java.util.List;

public interface CustomUserRepository {
    void addUser(User user);
    List<Ticket> findTicketByUser(User User);
    boolean existsById(int id);
    void save(User user);

}