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
    EntityManager entityManager;


    @Override
    @Transactional
    public void addAuditorium(Auditorium auditorium) {
        entityManager.persist(auditorium);
    }
}