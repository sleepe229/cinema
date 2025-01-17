package org.example.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "users")
public class User extends BaseEntity {
    private String fullname;
    private String phoneNumber;
    private Date lastBoughtTicket;

    protected User(){}

    public User(String fullname, String phoneNumber, Date lastBoughtTicket) {
        this.fullname = fullname;
        this.phoneNumber = phoneNumber;
        this.lastBoughtTicket = lastBoughtTicket;
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
