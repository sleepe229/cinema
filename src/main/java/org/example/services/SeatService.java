package org.example.services;

import org.example.dto.SeatDTO;
import org.example.entities.Seat;

public interface SeatService {
    Seat addSeat(SeatDTO seat);
}
