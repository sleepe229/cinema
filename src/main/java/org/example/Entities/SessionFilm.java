package org.example.Entities;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "session")
public class SessionFilm {
    private int id;
    private Auditorium auditorium;
    private Film film;
    private Date sessionDate;
    private String status;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "session_id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "auditorium_id", referencedColumnName = "auditorium_id")
    public Auditorium getAuditorium() {
        return auditorium;
    }

    public void setAuditorium(Auditorium auditorium) {
        this.auditorium = auditorium;
    }

    @ManyToOne
    @JoinColumn(name = "film_id", referencedColumnName = "film_id")
    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    @Column(name = "session_date")
    public Date getSessionDate() {
        return sessionDate;
    }

    public void setSessionDate(Date sessionDate) {
        this.sessionDate = sessionDate;
    }

    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
