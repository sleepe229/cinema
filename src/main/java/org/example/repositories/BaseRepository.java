package org.example.repositories;

import jakarta.transaction.Transactional;
import org.example.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

@NoRepositoryBean
public interface BaseRepository<T, Integer> extends Repository<T, Integer> {
    @Transactional
    void save(Object object);
}