package org.example;

import org.example.entities.*;
import org.example.services.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class ConsoleRunner implements CommandLineRunner {
    @Autowired
    private UserService userService;

    @Override
    public void run(String... strings) throws Exception {
        User user = new User("test", "test", new Date());
        userService.addUser(user);

    }
}