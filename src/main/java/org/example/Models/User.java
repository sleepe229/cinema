package org.example.Models;

import jakarta.persistence.*;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import java.util.Date;

@Entity
@Table(name = "users")
public class User {
    private int id;
    private String fullname;
    private String phoneNumber;
    private Date lastBoughtTicket;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "fullname")
    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    @Column(name = "phone_number")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Column(name = "last_bought_ticket")
    public Date getLastBoughtTicket() {
        return lastBoughtTicket;
    }

    public void setLastBoughtTicket(Date lastBoughtTicket) {
        this.lastBoughtTicket = lastBoughtTicket;
    }
}
