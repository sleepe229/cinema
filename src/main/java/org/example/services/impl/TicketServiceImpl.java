package org.example.services.impl;

import org.example.dto.TicketDTO;
import org.example.entities.Cinema;
import org.example.entities.SessionFilm;
import org.example.entities.Ticket;
import org.example.entities.User;
import org.example.repositories.*;
import org.example.services.TicketService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;
    private final CustomTicketRepository cTicketRepository;
    private final CustomSeatRepository customSeatRepository;
    private final CustomSessionRepository customSessionRepository;
    private final CustomUserRepository customUserRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public TicketServiceImpl(TicketRepository ticketRepository, CustomTicketRepository cTicketRepository, CustomSeatRepository customSeatRepository, CustomSessionRepository customSessionRepository, CustomUserRepository customUserRepository, ModelMapper modelMapper) {
        this.ticketRepository = ticketRepository;
        this.cTicketRepository = cTicketRepository;
        this.customSeatRepository = customSeatRepository;
        this.customSessionRepository = customSessionRepository;
        this.customUserRepository = customUserRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<TicketDTO> getAllTicketsByStatus(String status) {
        List<Ticket> tickets = ticketRepository.findAllByStatus(status);
        return tickets.stream().map(ticket -> modelMapper.map(ticket, TicketDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<TicketDTO> getAllTicketsByCinemaAndSessionFilm(Cinema cinema, SessionFilm sessionFilm) {
        List<Ticket> tickets = ticketRepository.findAllByCinemaAndSessionFilm(cinema, sessionFilm);
        return tickets.stream().map(ticket -> modelMapper.map(ticket, TicketDTO.class)).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void addTicket(TicketDTO ticketDTO) {
        Ticket ticket = modelMapper.map(ticketDTO, Ticket.class);

        if (ticket.getUser() != null) {
            customUserRepository.saveUser(ticket.getUser());
        }

        if (ticket.getSeat() != null) {
            customSeatRepository.save(ticket.getSeat());
        }
        if (ticket.getSession() != null) {
            customSessionRepository.saveSessionFilm(ticket.getSession());
        }

        cTicketRepository.addTicket(ticket);
    }

    @Override
    @Transactional
    public boolean lockTicket(int id) {
        Optional<Ticket> optionalTicket = ticketRepository.findById(id);
        if (optionalTicket.isPresent()) {
            Ticket ticket = optionalTicket.get();
            if ("AVAILABLE".equals(ticket.getStatus())) {
                ticketRepository.updateTicketStatus(id, "LOCKED", LocalDateTime.now());
                return true;
            }
        }
        return false;
    }

    @Override
    @Transactional
    public void unlockExpiredTickets() {
        List<Ticket> lockedTicketsExpired = ticketRepository.findAllLockedTicketsExpired(LocalDateTime.now().minusMinutes(15));
        lockedTicketsExpired.forEach(ticket -> ticketRepository.updateTicketStatus(ticket.getId(), "AVAILABLE", LocalDateTime.now()));
    }

    @Override
    @Transactional
    public void buyTicket(int id) {
        Optional<Ticket> optionalTicket = ticketRepository.findById(id);
        if (optionalTicket.isPresent()) {
            Ticket ticket = optionalTicket.get();
            if ("LOCKED".equals(ticket.getStatus())) {
                ticketRepository.updateTicketStatus(id, "SOLD", LocalDateTime.now());
            }
        }
    }

    @Override
    @Transactional
    public void discountTicket(User user, int id, float cost){
        final double FULL_PRICE = 1.0;
        final double DISCOUNT_25 = 0.75;
        final double DISCOUNT_50 = 0.5;
        final double DISCOUNT_75 = 0.25;
        List<Ticket> userTickets = ticketRepository.findByUser(user);
        Ticket ticket = ticketRepository.findById(id).orElse(null);
        if(ticket != null) {
            switch (userTickets.size()) {
                case 0  -> ticket.setCost((float) (cost * FULL_PRICE));
                case 1 -> ticket.setCost((float) (cost * DISCOUNT_25));
                case 2 -> ticket.setCost((float) (cost * DISCOUNT_50));
                default -> ticket.setCost((float) (cost * DISCOUNT_75));
            }
            cTicketRepository.save(ticket);
        }
    }
}
