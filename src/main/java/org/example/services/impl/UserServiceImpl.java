package org.example.services.impl;

import org.example.entities.Cinema;
import org.example.entities.SessionFilm;
import org.example.entities.Ticket;

import org.example.entities.User;
import org.example.repositories.UserRepository;
import org.example.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public void addUser(User user) {
        userRepository.addUser(user);
    }

    @Override
    public List<User> findAllTicketsByUser(User User) {
        return null;
    }

}