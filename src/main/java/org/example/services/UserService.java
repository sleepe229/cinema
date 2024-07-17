package org.example.services;

import org.example.dto.UserDTO;
import org.example.entities.Ticket;
import org.example.entities.User;

import java.util.List;

public interface UserService{
    User addUser(UserDTO user);
}

