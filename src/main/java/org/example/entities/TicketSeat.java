package org.example.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "seat_ticket")
public class TicketSeat extends BaseEntity {
    private Ticket ticket;
    private Seat seat;

    @ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn(name = "ticket_id", referencedColumnName = "id")
    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    @ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn(name = "seat_id", referencedColumnName = "id")
    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }
}
