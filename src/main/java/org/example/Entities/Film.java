package org.example.Entities;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "film")
public class Film {
    private int id;
    private String name;
    private String type;
    private String director;
    private Date dateOfRelease;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "film_id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Column(name = "director")
    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Column(name = "date_of_release")
    public Date getDateOfRelease() {
        return dateOfRelease;
    }

    public void setDateOfRelease(Date dateOfRelease) {
        this.dateOfRelease = dateOfRelease;
    }
}
