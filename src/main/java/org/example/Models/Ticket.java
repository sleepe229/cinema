package org.example.Models;

import jakarta.persistence.*;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import java.util.Date;

@Entity
@Table(name = "ticket")
public class Ticket {
    private int id;
    private SessionFilm session;
    private User user;
    private Seat seat;
    private int cost;
    private String status;
    private Date lastTimeChangeStatus;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticket_id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "session_id", referencedColumnName = "session_id")
    public SessionFilm getSession() {
        return session;
    }

    public void setSession(SessionFilm session) {
        this.session = session;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne
    @JoinColumn(name = "seat_id", referencedColumnName = "seat_id")
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
