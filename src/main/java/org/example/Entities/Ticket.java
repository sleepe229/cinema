package org.example.Entities;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ticket")
public class Ticket extends BaseEntity{
    private SessionFilm session;
    private User user;
    private Seat seat;
    private int cost;
    private String status;
    private Date lastTimeChangeStatus;

    protected Ticket(){}
    @ManyToOne(fetch = FetchType.LAZY)
    public SessionFilm getSession() {
        return session;
    }

    public void setSession(SessionFilm session) {
        this.session = session;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne(fetch = FetchType.LAZY)
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
    public Date getLastTimeChangeStatus() {
        return lastTimeChangeStatus;
    }

    public void setLastTimeChangeStatus(Date lastTimeChangeStatus) {
        this.lastTimeChangeStatus = lastTimeChangeStatus;
    }
}
