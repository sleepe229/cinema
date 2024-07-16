package org.example.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "auditorium")
public class Auditorium extends BaseEntity{
    private int capacity;
    private Cinema cinema;
    private String type;

    public Auditorium(){}

    @Column(name = "capacity")
    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cinema_id", referencedColumnName = "id")
    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
