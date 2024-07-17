package org.example;

import org.example.dto.*;
import org.example.entities.*;
import org.example.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.modelmapper.ModelMapper;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Component
public class ConsoleRunner implements CommandLineRunner {

    @Autowired
    private UserService userService;

    @Autowired
    private AuditoriumService auditoriumService;

    @Autowired
    private CinemaService cinemaService;

    @Autowired
    private FilmService filmService;

    @Autowired
    private SeatService seatService;

    @Autowired
    private SessionService sessionService;

    @Autowired
    private TicketService ticketService;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void run(String... args) throws Exception {
        // Сохраняем пользователя
        UserDTO userDTO = new UserDTO("John Doe", "123456789", LocalDateTime.now());
        User savedUser = userService.addUser(userDTO);
        if (savedUser == null || savedUser.getId() == 0) {
            System.err.println("Failed to save User");
            return;
        }

        // Сохраняем кинотеатр и получаем его объект
        CinemaDTO cinemaDTO = new CinemaDTO();
        cinemaDTO.setAddress("123 Main St");
        cinemaDTO.setName("Main Street Cinema");
        Cinema savedCinema = cinemaService.addCinema(cinemaDTO);
        if (savedCinema == null || savedCinema.getId() == 0) {
            System.err.println("Failed to save Cinema");
            return;
        }

        // Используем сохраненный объект Cinema для создания Auditorium
        AuditoriumDTO auditoriumDTO = new AuditoriumDTO();
        auditoriumDTO.setCapacity(100);
        auditoriumDTO.setCinemaId(cinemaDTO.getId());
        auditoriumDTO.setType("Standard");
        Auditorium savedAuditorium = auditoriumService.addAuditorium(auditoriumDTO);

        // Сохраняем фильм
        FilmDTO filmDTO = new FilmDTO();
        filmDTO.setName("The Great Movie");
        filmDTO.setType("Action");
        filmDTO.setDirector("Jane Doe");
        filmDTO.setDateOfRelease(new Date());
        Film savedFilm = filmService.addFilm(filmDTO);

        // Сохраняем сеанс
        SessionFilmDTO sessionFilmDTO = new SessionFilmDTO();
        sessionFilmDTO.setAuditoriumId(auditoriumDTO.getId());
        sessionFilmDTO.setFilmId(filmDTO.getId());
        sessionFilmDTO.setSessionDate(new Date());
        sessionFilmDTO.setStatus("Scheduled");
        SessionFilm savedSession = sessionService.addSession(sessionFilmDTO);

        // Сохраняем место
        SeatDTO seatDTO = new SeatDTO();
        seatDTO.setNumberOfRow(1);
        seatDTO.setNumberOfSeat(1);
        seatDTO.setAuditoriumId(auditoriumDTO.getId());
        Seat savedSeat = seatService.addSeat(seatDTO);

        // Сохраняем билет
        TicketDTO ticketDTO = new TicketDTO();
        ticketDTO.setSessionId(sessionFilmDTO.getId());
        ticketDTO.setUserId(userDTO.getId());
        ticketDTO.setSeatId(seatDTO.getId());
        ticketDTO.setCost(10.0f);
        ticketDTO.setStatus("AVAILABLE");
        ticketDTO.setLastTimeChangeStatus(LocalDateTime.now());
        ticketService.addTicket(ticketDTO);

        // Блокируем билет
        boolean isLocked = ticketService.lockTicket(ticketDTO.getId());
        if (isLocked) {
            System.out.println("Ticket locked successfully.");
        } else {
            System.out.println("Failed to lock ticket.");
        }

        // Разблокируем просроченные билеты и покупаем билет
        ticketService.unlockExpiredTickets();
        ticketService.buyTicket(ticketDTO.getId());

        // Применяем скидку на билет
        ticketService.discountTicket(savedUser, ticketDTO.getId(), 10.0f);

        // Рекомендуем фильмы по жанрам пользователя
        List<FilmDTO> recommendedFilms = filmService.recommendFilmsByUserGenres(savedUser);
        System.out.println("Recommended films: " + recommendedFilms);

        // Получаем все билеты со статусом "SOLD"
        List<TicketDTO> ticketsByStatus = ticketService.getAllTicketsByStatus("SOLD");
        System.out.println("Tickets with status 'SOLD': " + ticketsByStatus);
    }
}
