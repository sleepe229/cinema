package org.example.controllers;

import org.example.dto.SeatDTO;
import org.example.services.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/seat")
public class SeatController {

    private final SeatService seatService;

    @Autowired
    public SeatController(SeatService seatService) {
        this.seatService = seatService;
    }

    @PostMapping
    public ResponseEntity<Void> addSeat(@RequestBody SeatDTO seatDTO) {
        seatService.addSeat(seatDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
