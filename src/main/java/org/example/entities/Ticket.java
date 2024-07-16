package org.example.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "ticket")
public class Ticket extends BaseEntity {
    private SessionFilm session;
    private User user;
    private Seat seat;
    private float cost;
    private String status;
    private LocalDateTime lastTimeChangeStatus;
    private Set<TicketSeat> ticketSeats;

    public Ticket() {}

    @ManyToOne(fetch = FetchType.LAZY)
    public SessionFilm getSession() {
        return session;
    }

    public void setSession(SessionFilm session) {
        this.session = session;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seat_id", referencedColumnName = "id")
    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    @Column(name = "cost")
    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Column(name = "last_time_change_status")
    public LocalDateTime getLastTimeChangeStatus() {
        return lastTimeChangeStatus;
    }

    public void setLastTimeChangeStatus(LocalDateTime lastTimeChangeStatus) {
        this.lastTimeChangeStatus = lastTimeChangeStatus;
    }

    @OneToMany(mappedBy = "ticket", fetch = FetchType.LAZY)
    public Set<TicketSeat> getTicketSeats() {
        return ticketSeats;
    }

    public void setTicketSeats(Set<TicketSeat> ticketSeats) {
        this.ticketSeats = ticketSeats;
    }
}
