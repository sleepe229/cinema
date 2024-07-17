package org.example.services.impl;

import org.example.dto.SeatDTO;
import org.example.entities.Seat;
import org.example.repositories.CustomSeatRepository;
import org.example.services.SeatService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SeatServiceImpl implements SeatService {

    private final CustomSeatRepository SeatRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public SeatServiceImpl(CustomSeatRepository seatRepository, ModelMapper modelMapper) {
        this.SeatRepository = seatRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    @Transactional
    public Seat addSeat(SeatDTO seatDTO) {
        Seat seat = modelMapper.map(seatDTO, Seat.class);
        SeatRepository.save(seat);
        return seat;
    }


}
