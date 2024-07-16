package org.example;

import org.example.entities.*;
import org.example.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

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

    @Override
    public void run(String... args) throws Exception {
        // Adding a user
        User user = new User("John Doe", "123456789", new Date());
        userService.addUser(user);

        // Adding a cinema
        Cinema cinema = new Cinema();
        cinema.setAddress("123 Main St");
        cinema.setName("Main Street Cinema");
        cinemaService.addCinema(cinema);

        // Adding an auditorium
        Auditorium auditorium = new Auditorium();
        auditorium.setCapacity(100);
        auditorium.setCinema(cinema);
        auditorium.setType("Standard");
        auditoriumService.addAuditorium(auditorium);

        // Adding a film
        Film film = new Film();
        film.setName("The Great Movie");
        film.setType("Action");
        film.setDirector("Jane Doe");
        film.setDateOfRelease(new Date());
        filmService.addFilm(film);

        // Adding a session
        SessionFilm sessionFilm = new SessionFilm();
        sessionFilm.setAuditorium(auditorium);
        sessionFilm.setFilm(film);
        sessionFilm.setSessionDate(new Date());
        sessionFilm.setStatus("Scheduled");
        sessionService.addSession(sessionFilm);

        // Adding a seat
        Seat seat = new Seat();
        seat.setNumberOfRow(1);
        seat.setNumberOfSeat(1);
        seat.setAuditorium(auditorium);
        seatService.addSeat(seat);

        // Adding a ticket
        Ticket ticket = new Ticket();
        ticket.setSession(sessionFilm);
        ticket.setUser(user);
        ticket.setSeat(seat);
        ticket.setCost(10.0f);
        ticket.setStatus("AVAILABLE");
        ticket.setLastTimeChangeStatus(LocalDateTime.now());
        ticketService.addTicket(ticket);

        // Locking a ticket
        boolean isLocked = ticketService.lockTicket(ticket.getId());
        if (isLocked) {
            System.out.println("Ticket locked successfully.");
        } else {
            System.out.println("Failed to lock ticket.");
        }

        // Unlocking expired tickets
        ticketService.unlockExpiredTickets();

        // Buying a ticket
        ticketService.buyTicket(ticket.getId());

        // Applying discount to a ticket
        ticketService.discountTicket(user, ticket.getId(), 10.0f);

        // Recommending films for a user
        List<Film> recommendedFilms = filmService.recommendFilmsByUserGenres(user);
        System.out.println("Recommended films: " + recommendedFilms);

        // Fetching all tickets by status
        List<Ticket> ticketsByStatus = ticketService.getAllTicketsByStatus("SOLD");
        System.out.println("Tickets with status 'SOLD': " + ticketsByStatus);
    }
}
