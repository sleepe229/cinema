package org.example.services;

import org.example.dto.TicketDTO;
import org.example.dto.UserDTO;
import org.example.entities.Cinema;
import org.example.entities.SessionFilm;
import org.example.entities.Ticket;
import org.example.entities.User;

import java.util.List;

public interface TicketService {

    List<TicketDTO> getAllTicketsByStatus(String status);

    List<TicketDTO> getAllTicketsByCinemaAndSessionFilm(Cinema cinema, SessionFilm sessionFilm);

    void addTicket(TicketDTO ticket);

    boolean lockTicket(int id);

    void unlockExpiredTickets();

    void buyTicket(int ticketId);

    void discountTicket(User user, int id, float cost);
}
