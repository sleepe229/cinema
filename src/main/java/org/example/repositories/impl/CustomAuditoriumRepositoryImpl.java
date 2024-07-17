package org.example.repositories.impl;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.example.entities.Auditorium;
import org.example.repositories.CustomAuditoriumRepository;
import org.springframework.stereotype.Repository;

@Repository
public class CustomAuditoriumRepositoryImpl implements CustomAuditoriumRepository {
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    @Transactional
    public void addAuditorium(Auditorium auditorium) {
        entityManager.persist(auditorium);
    }

    @Override
    @Transactional
    public void save(Auditorium auditorium) {
        if (auditorium.getId() != 0) {
            entityManager.merge(auditorium);
        } else {
            addAuditorium(auditorium);
        }
    }
}
