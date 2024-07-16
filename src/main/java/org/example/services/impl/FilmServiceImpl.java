package org.example.services.impl;

import jakarta.transaction.Transactional;
import org.example.entities.Film;
import org.example.entities.Ticket;
import org.example.entities.User;
import org.example.repositories.CustomFilmRepository;
import org.example.repositories.FilmRepository;
import org.example.repositories.TicketRepository;
import org.example.services.FilmService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FilmServiceImpl implements FilmService {
    private final FilmRepository filmRepository;
    private final CustomFilmRepository customFilmRepository;
    private final TicketRepository ticketRepository;

    public FilmServiceImpl(FilmRepository filmRepository, CustomFilmRepository customFilmRepository, TicketRepository ticketRepository) {
        this.filmRepository = filmRepository;
        this.customFilmRepository = customFilmRepository;
        this.ticketRepository = ticketRepository;
    }

    @Override
    @Transactional
    public void addFilm(Film film){
        customFilmRepository.addFilm(film);
    }

    @Override
    @Transactional
    public List<Film> recommendFilmsByUserGenres(User user) {
        List<Ticket> userTickets = ticketRepository.findByUser(user);
        List<String> genres = userTickets.stream()
                .map(ticket -> ticket.getSession().getFilm().getType())
                .distinct()
                .collect(Collectors.toList());

        return filmRepository.findFilmsByTypeNotWatchedByUser(genres, user);
    }
}
