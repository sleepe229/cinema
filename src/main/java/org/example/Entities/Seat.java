package org.example.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "seat")
public class Seat extends BaseEntity{
    private int numberOfRow;
    private int numberOfSeat;
    private Auditorium auditorium;
    private Ticket ticket;

    protected Seat(){}

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
    public Auditorium getAuditorium() {
        return auditorium;
    }

    public void setAuditorium(Auditorium auditorium) {
        this.auditorium = auditorium;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}
