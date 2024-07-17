package org.example.dto;

import java.time.LocalDateTime;

public class TicketDTO {
    private int id;
    private int sessionId;
    private int userId;
    private int seatId;
    private float cost;
    private String status;
    private LocalDateTime lastTimeChangeStatus;

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getSeatId() {
        return seatId;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getLastTimeChangeStatus() {
        return lastTimeChangeStatus;
    }

    public void setLastTimeChangeStatus(LocalDateTime lastTimeChangeStatus) {
        this.lastTimeChangeStatus = lastTimeChangeStatus;
    }
}
