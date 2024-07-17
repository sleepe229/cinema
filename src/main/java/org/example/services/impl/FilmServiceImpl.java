package org.example.services.impl;

import jakarta.transaction.Transactional;
import org.example.dto.FilmDTO;
import org.example.entities.Film;
import org.example.entities.Ticket;
import org.example.entities.User;
import org.example.repositories.CustomFilmRepository;
import org.example.repositories.FilmRepository;
import org.example.repositories.TicketRepository;
import org.example.services.FilmService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FilmServiceImpl implements FilmService {
    private final FilmRepository filmRepository;
    private final CustomFilmRepository customFilmRepository;
    private final TicketRepository ticketRepository;
    private final ModelMapper modelMapper;

    public FilmServiceImpl(FilmRepository filmRepository, CustomFilmRepository customFilmRepository, TicketRepository ticketRepository, ModelMapper modelMapper) {
        this.filmRepository = filmRepository;
        this.customFilmRepository = customFilmRepository;
        this.ticketRepository = ticketRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    @Transactional
    public Film addFilm(FilmDTO filmDTO){
        Film film = modelMapper.map(filmDTO, Film.class);
        customFilmRepository.save(film);
        return film;
    }

    @Override
    @Transactional
    public List<FilmDTO> recommendFilmsByUserGenres(User user) {
        List<Ticket> userTickets = ticketRepository.findByUser(user);
        List<String> genres = userTickets.stream()
                .map(ticket -> ticket.getSession().getFilm().getType())
                .distinct()
                .collect(Collectors.toList());

        List<Film> films = filmRepository.findFilmsByTypeNotWatchedByUser(genres, user);
        return films.stream().map(film -> modelMapper.map(film, FilmDTO.class)).collect(Collectors.toList());
    }
}
