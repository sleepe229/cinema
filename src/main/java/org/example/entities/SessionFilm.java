package org.example.entities;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "session")
public class SessionFilm extends BaseEntity{
    private Auditorium auditorium;
    private Film film;
    private Date sessionDate;
    private String status;

   protected SessionFilm(){}


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "auditorium_id", referencedColumnName = "id")
    public Auditorium getAuditorium() {
        return auditorium;
    }

    public void setAuditorium(Auditorium auditorium) {
        this.auditorium = auditorium;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "film_id", referencedColumnName = "id")
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
