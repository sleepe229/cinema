package org.example.repositories;

import org.example.entities.Film;
import org.example.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmRepository extends BaseRepository<Film, Integer>{

    @Query("SELECT f FROM Film f WHERE f.type IN :types AND f.id NOT IN (SELECT t.session.film.id FROM Ticket t WHERE t.user = :user)")
    List<Film> findFilmsByTypeNotWatchedByUser(@Param("types") List<String> types, @Param("user") User user);
}