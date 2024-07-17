package org.example.controllers;

import org.example.dto.SessionFilmDTO;
import org.example.services.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/session")
public class SessionController {

    private final SessionService sessionService;

    @Autowired
    public SessionController(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    @PostMapping
    public ResponseEntity<Void> addSession(@RequestBody SessionFilmDTO sessionFilmDTO) {
        sessionService.addSession(sessionFilmDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
