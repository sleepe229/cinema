package org.example.services.impl;

import org.example.entities.Seat;
import org.example.repositories.CustomSeatRepository;
import org.example.services.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SeatServiceImpl implements SeatService {

    private final CustomSeatRepository SeatRepository;


    @Autowired
    public SeatServiceImpl(CustomSeatRepository SeatFilmRepository) {
        this.SeatRepository = SeatFilmRepository;
    }

    @Override
    @Transactional
    public void addSeat(Seat seat) {
        SeatRepository.addSeat(seat);
    }

}
