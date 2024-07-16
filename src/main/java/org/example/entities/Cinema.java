package org.example.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "cinema")
public class Cinema extends BaseEntity{
    private String address;
    private String name;

    public Cinema(){}

    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
