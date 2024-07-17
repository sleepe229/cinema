package org.example.services.impl;

import org.example.dto.AuditoriumDTO;
import org.example.entities.Auditorium;
import org.example.repositories.AuditoriumRepository;
import org.example.repositories.CustomAuditoriumRepository;
import org.example.services.AuditoriumService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuditoriumServiceImpl implements AuditoriumService {
    private final AuditoriumRepository auditoriumRepository;
    private final CustomAuditoriumRepository customAuditoriumRepository;
    private final ModelMapper modelMapper;

    public AuditoriumServiceImpl(AuditoriumRepository auditoriumRepository, CustomAuditoriumRepository customAuditoriumRepository, ModelMapper modelMapper) {
        this.auditoriumRepository = auditoriumRepository;
        this.customAuditoriumRepository = customAuditoriumRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    @Transactional
    public Auditorium addAuditorium(AuditoriumDTO auditoriumDTO) {
        Auditorium auditorium = modelMapper.map(auditoriumDTO, Auditorium.class);
        customAuditoriumRepository.save(auditorium);
        return auditorium;
    }
}

