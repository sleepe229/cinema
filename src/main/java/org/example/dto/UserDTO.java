package org.example.dto;

import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;
import java.util.Date;

public class UserDTO {
    private int id;
    private String fullname;
    private String phoneNumber;
    private LocalDateTime lastBoughtTicket;

    public UserDTO(String fullname, String phoneNumber, LocalDateTime lastBought) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDateTime getLastBoughtTicket() {
        return lastBoughtTicket;
    }

    public void setLastBoughtTicket(LocalDateTime lastBoughtTicket) {
        this.lastBoughtTicket = lastBoughtTicket;
    }
}