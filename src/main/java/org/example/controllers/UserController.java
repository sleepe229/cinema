package org.example.controllers;

import org.example.dto.UserDTO;
import org.example.entities.User;
import org.example.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private final UserService userService;
    private final ModelMapper modelMapper;

    @Autowired
    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/add/user")
    public ResponseEntity<User> add(@RequestBody UserDTO userDTO) {
//        User user = modelMapper.map(userDTO, User.class);
//        userService.addUser(user);
//        return ResponseEntity.status(HttpStatus.CREATED).build();
        userService.addUser(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
