package org.example.controllers;

import org.example.dto.AuditoriumDTO;
import org.example.services.AuditoriumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuditoriumController {

    private final AuditoriumService auditoriumService;

    @Autowired
    public AuditoriumController(AuditoriumService auditoriumService) {
        this.auditoriumService = auditoriumService;
    }

    @PostMapping("/add/auditorium")
    public ResponseEntity<Void> addAuditorium(@RequestBody AuditoriumDTO auditoriumDTO) {
        auditoriumService.addAuditorium(auditoriumDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
