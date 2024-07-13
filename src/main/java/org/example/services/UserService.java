package org.example.services;

import org.example.entities.Ticket;
import org.example.entities.User;

import java.util.List;

public interface UserService{
    void addUser(User user);

    List<User> findAllTicketsByUser(User User);

}

