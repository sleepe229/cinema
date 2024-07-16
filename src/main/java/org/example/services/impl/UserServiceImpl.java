package org.example.services.impl;

import org.example.entities.User;
import org.example.repositories.CustomUserRepository;
import org.example.repositories.UserRepository;
import org.example.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final CustomUserRepository customUserRepository;
    private final ModelMapper modelMapper = new ModelMapper();


    @Autowired
    public UserServiceImpl(UserRepository userRepository, CustomUserRepository customUserRepository) {
        this.userRepository = userRepository;
        this.customUserRepository = customUserRepository;
    }

    @Override
    @Transactional
    public void addUser(User user) {
        customUserRepository.addUser(user);
    }

}