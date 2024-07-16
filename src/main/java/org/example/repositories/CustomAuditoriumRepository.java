package org.example.repositories;

import jakarta.transaction.Transactional;
import org.example.entities.Auditorium;

public interface CustomAuditoriumRepository {
    @Transactional
    void addAuditorium(Auditorium auditorium);
}
