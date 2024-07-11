package org.example.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "auditorium")
public class Auditorium {
    private int id;
    private int capacity;
    private Cinema cinema;
    private String type;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "auditorium_id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "capacity")
    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cinema_id", referencedColumnName = "cinema_id")
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
