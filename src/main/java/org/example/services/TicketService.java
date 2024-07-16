package org.example.services;

import org.example.entities.Cinema;
import org.example.entities.SessionFilm;
import org.example.entities.Ticket;
import org.example.entities.User;

import java.util.List;

public interface TicketService {

    List<Ticket> getAllTicketsByStatus(String status);

    List<Ticket> getAllTicketsByCinemaAndSessionFilm(Cinema cinema, SessionFilm sessionFilm);

    void addTicket(Ticket ticket);

    boolean lockTicket(int id);

    void unlockExpiredTickets();

    void buyTicket(int ticketId);

    void discountTicket(User user, int id, float cost);
}
