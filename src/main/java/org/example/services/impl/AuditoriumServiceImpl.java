package org.example.services.impl;

import org.example.entities.Auditorium;
import org.example.repositories.AuditoriumRepository;
import org.example.repositories.CustomAuditoriumRepository;
import org.example.services.AuditoriumService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuditoriumServiceImpl implements AuditoriumService {
    private final AuditoriumRepository auditoriumRepository;
    private final CustomAuditoriumRepository customAuditoriumRepository;

    public AuditoriumServiceImpl(AuditoriumRepository auditoriumRepository, CustomAuditoriumRepository customAuditoriumRepository) {
        this.auditoriumRepository = auditoriumRepository;
        this.customAuditoriumRepository = customAuditoriumRepository;
    }

    @Override
    @Transactional
    public void addAuditorium(Auditorium auditorium) {
        customAuditoriumRepository.addAuditorium(auditorium);
    }
}
