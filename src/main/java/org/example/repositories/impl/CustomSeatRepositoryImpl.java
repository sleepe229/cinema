package org.example.repositories.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.example.entities.Seat;
import org.example.repositories.CustomSeatRepository;
import org.example.repositories.SeatRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class CustomSeatRepositoryImpl implements CustomSeatRepository {

    @PersistenceContext
    private EntityManager entityManager;

    private final SeatRepository seatRepository;

    public CustomSeatRepositoryImpl(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }

    @Override
    public void addSeat(Seat seat) {
        entityManager.persist(seat);
    }

    @Override
    @Transactional
    public void save(Seat seat) {
        if (seat.getId() != 0) {
            entityManager.merge(seat);
        } else {
            addSeat(seat);
        }
    }
}
