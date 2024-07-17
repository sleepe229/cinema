package org.example.services.impl;

import org.example.dto.CinemaDTO;
import org.example.entities.Cinema;
import org.example.repositories.CustomCinemaRepository;
import org.example.services.CinemaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CinemaServiceImpl implements CinemaService {

    private final CustomCinemaRepository customCinemaRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public CinemaServiceImpl(CustomCinemaRepository customCinemaRepository, ModelMapper modelMapper) {
        this.customCinemaRepository = customCinemaRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    @Transactional
    public Cinema addCinema(CinemaDTO cinemaDTO) {
        Cinema cinema = modelMapper.map(cinemaDTO, Cinema.class);
        customCinemaRepository.save(cinema);
        System.out.println("Cinema saved with ID: " + cinema.getId());
        return cinema;
    }
}
