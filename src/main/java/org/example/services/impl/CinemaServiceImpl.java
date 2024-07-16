package org.example.services.impl;

import org.example.entities.Cinema;
import org.example.repositories.CinemaRepository;
import org.example.repositories.CustomCinemaRepository;
import org.example.services.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CinemaServiceImpl implements CinemaService {
    private final CinemaRepository cinemaRepository;
    private final CustomCinemaRepository customCinemaRepository;

    @Autowired
    public CinemaServiceImpl(CinemaRepository cinemaRepository, CustomCinemaRepository customCinemaRepository) {
        this.cinemaRepository = cinemaRepository;
        this.customCinemaRepository = customCinemaRepository;
    }

    @Override
    @Transactional
    public void addCinema(Cinema cinema) {
        customCinemaRepository.addCinema(cinema);
    }
}
