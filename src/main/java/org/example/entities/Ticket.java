package org.example.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "ticket")
public class Ticket extends BaseEntity{
    private SessionFilm session;
    private User user;
    private Seat seat;
    private int cost;
    private String status;
    private LocalDateTime lastTimeChangeStatus;

    protected Ticket(){}
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
    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
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
}
