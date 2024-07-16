package org.example.entities;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "seat")
public class Seat extends BaseEntity {
    private int numberOfRow;
    private int numberOfSeat;
    private Auditorium auditorium;
    private Set<TicketSeat> ticketSeats;

    public Seat() {}

    @Column(name = "number_of_row")
    public int getNumberOfRow() {
        return numberOfRow;
    }

    public void setNumberOfRow(int numberOfRow) {
        this.numberOfRow = numberOfRow;
    }

    @Column(name = "number_of_seat")
    public int getNumberOfSeat() {
        return numberOfSeat;
    }

    public void setNumberOfSeat(int numberOfSeat) {
        this.numberOfSeat = numberOfSeat;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "auditorium_id", referencedColumnName = "id")
    public Auditorium getAuditorium() {
        return auditorium;
    }

    public void setAuditorium(Auditorium auditorium) {
        this.auditorium = auditorium;
    }

    @OneToMany(mappedBy = "seat", fetch = FetchType.LAZY)
    public Set<TicketSeat> getTicketSeats() {
        return ticketSeats;
    }

    public void setTicketSeats(Set<TicketSeat> ticketSeats) {
        this.ticketSeats = ticketSeats;
    }
}
