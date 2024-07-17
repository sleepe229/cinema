package org.example.services;

import org.example.dto.AuditoriumDTO;
import org.example.entities.Auditorium;

public interface AuditoriumService {
    Auditorium addAuditorium(AuditoriumDTO auditorium);
}
